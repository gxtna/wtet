package com.gxtna.wtet.entity.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*   @author gxtna
*   @date 2022/11/29 下午2:24
*   @desciption: 菜单的返回二级类
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeFather {
    private String status;
    private String msg;
    private RecipeChildren result;
}
