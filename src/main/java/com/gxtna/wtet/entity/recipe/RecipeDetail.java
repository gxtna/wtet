package com.gxtna.wtet.entity.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author gxtna
 * @date 2022/11/29 下午2:28
 * @desciption: 菜单的返回详情类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDetail {
    private String id;
    private String classid;
    private String name;
    private String peoplenum;
    private String preparetime;
    private String cookingtime;
    private String content;
    private String pic;
    private String tag;
    private List<RecipeMaterial> material;
    private List<RecipeProcess> process;
}
