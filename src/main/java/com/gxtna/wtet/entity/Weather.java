package com.gxtna.wtet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    private String city;
    private String acCode;
    private String province;
    private LocalDateTime reportTime;
    private List<WeatherChildren> casts;
}
