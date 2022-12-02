package com.gxtna.wtet.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 天气信息表
 * </p>
 *
 * @author gxtna
 * @since 2022-12-02
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Weather对象", description = "天气信息表")
public class Weather implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("天气信息表ID")
    private String id;

    @ApiModelProperty("天气名称")
    private String weatherName;

    @ApiModelProperty("天气描述")
    private String weatherDesc;

    @ApiModelProperty("天气备注")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
