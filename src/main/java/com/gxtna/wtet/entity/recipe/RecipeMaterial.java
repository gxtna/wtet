package com.gxtna.wtet.entity.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gxtna
 * @date 2022/11/29 下午2:31
 * @desciption: 菜单的返回详情中的调料类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeMaterial {
    private String mname;
    private String type;
    private String amount;
}
