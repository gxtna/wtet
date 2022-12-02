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
 * 地区表
 * </p>
 *
 * @author gxtna
 * @since 2022-12-02
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Region对象", description = "地区表")
public class Region implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地区ID")
    private String id;

    @ApiModelProperty("地区名")
    private String regionName;

    @ApiModelProperty("地区描述")
    private String regionDesc;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
