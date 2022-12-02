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
 * 季节表
 * </p>
 *
 * @author gxtna
 * @since 2022-12-02
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Season对象", description = "季节表")
public class Season implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("季节表ID")
    private Integer id;

    @ApiModelProperty("季节名")
    private String seasonName;

    @ApiModelProperty("季节的开始时间")
    private LocalDateTime seasonStartTime;

    @ApiModelProperty("季节的结束时间")
    private LocalDateTime seasonEndTime;

    @ApiModelProperty("季节描述")
    private String seasonRemark;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
