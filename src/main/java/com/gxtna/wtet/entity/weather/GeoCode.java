package com.gxtna.wtet.entity.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author gxtna
 * @date 2022/11/29 下午3:45
 * @desciption: 获取城市码的root类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoCode {

    private String status;
    private String info;
    private String infocode;
    private String count;
    private List<GeoCodeChildren> geocodes;
}

