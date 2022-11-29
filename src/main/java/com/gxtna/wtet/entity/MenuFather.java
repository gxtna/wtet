package com.gxtna.wtet.entity;

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
public class MenuFather {
    private String status;
    private String msg;
    private MenuChildren result;
}
