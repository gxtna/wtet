package com.gxtna.wtet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherChildren {

    private LocalDate date;
    private String week;
    private String dayWeather;
    private String nightWeather;
    private String dayTemp;
    private String nightTemp;
    private String dayWind;
    private String nightWind;
    private String dayPower;
    private String nightPower;
}
