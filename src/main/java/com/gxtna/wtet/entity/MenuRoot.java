package com.gxtna.wtet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gxtna
 * @date 2022/11/29 下午2:22
 * @desciption: 菜单的返回根类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRoot {

    private String code ;
    private boolean charge;
    private String msg ;
    private MenuFather result;
}
