package com.gxtna.wtet.entity.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gxtna
 * @date 2022/11/29 下午3:45
 * @desciption: 获取城市码的子类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoCodeChildren {

    private String formattedAddress;
    private String country;
    private String province;
    private String citycode;
    private String city;
    private String district;
    private String adcode;
    private String location;
    private String level;
}
