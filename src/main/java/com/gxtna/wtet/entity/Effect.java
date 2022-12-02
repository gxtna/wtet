package com.gxtna.wtet.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 功效表
 * </p>
 *
 * @author gxtna
 * @since 2022-12-02
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Effect对象", description = "功效表")
public class Effect implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("功效表ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("功效名称")
    private String effectName;

    @ApiModelProperty("功效描述")
    private String effectDesc;

    @ApiModelProperty("功效备注")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
