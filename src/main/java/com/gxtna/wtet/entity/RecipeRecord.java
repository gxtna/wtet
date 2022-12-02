package com.gxtna.wtet.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单记录表(临时)
 * </p>
 *
 * @author gxtna
 * @since 2022-12-02
 */
@Data
@Accessors(chain = true)
@TableName("recipe_record")
@ApiModel(value = "RecipeRecord对象", description = "菜单记录表(临时)")
public class RecipeRecord implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("记录表id")
    private String id;

    @ApiModelProperty("天气标签(晴,阴...)")
    private String weatherId;

    @ApiModelProperty("功效标签(暖胃,解毒...)")
    private String effectId;

    @ApiModelProperty("地区标签(北方,南方)")
    private Integer regionId;

    @ApiModelProperty("季节标签(春,夏,秋,冬)")
    private String seasonId;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
