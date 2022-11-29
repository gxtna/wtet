package com.gxtna.wtet.entity.weather;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author gxtna
 * @date 2022/11/29 下午3:45
 * @desciption: 获取天气的子类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherChildren {
    private String province;
    private String city;
    private String adcode;
    private String weather;
    private String temperature;
    private String winddirection;
    private String windpower;
    private String humidity;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reporttime;
}
