package com.gxtna.wtet.entity.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author gxtna
 * @date 2022/11/29 下午2:27
 * @desciption: 菜单的返回三级类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeChildren {
    private String num;
    private List<RecipeDetail> list;
}
