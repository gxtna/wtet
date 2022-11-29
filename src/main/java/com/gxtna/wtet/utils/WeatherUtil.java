package com.gxtna.wtet.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gxtna.wtet.adapter.LocalDateTimeAdapter;
import com.gxtna.wtet.entity.weather.GeoCode;
import com.gxtna.wtet.entity.weather.Weather;
import com.gxtna.wtet.entity.weather.WeatherChildren;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author gxtna
 * @date 2022/11/29 下午2:24
 * @desciption: 天气获取类
 */
public class WeatherUtil {

    private static final String weatherApi = "https://restapi.amap.com/v3/weather/weatherInfo?";
    private static final String geocodeApi = "https://restapi.amap.com/v3/geocode/geo?";
    private static final String key = "adb0ec0ae1ca02547ffecc4933a64c48";
    private static final String privateKey = "4dfc24bd11c42e201e8625b32e60cb9f";


    public static WeatherChildren getWeatherData(String address) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,new LocalDateTimeAdapter()).create();
        GeoCode geoCode = gson.fromJson(getGeoCode(address), GeoCode.class);
        String adCode = null;
        if (Objects.nonNull(geoCode) && geoCode.getInfocode().equals("10000")) {
            if(!geoCode.getGeocodes().isEmpty()){
                adCode = geoCode.getGeocodes().get(0).getAdcode();
            }
        }
        Weather weather = gson.fromJson(getWeatherRealTime(adCode), Weather.class);
        if (Objects.nonNull(weather) && weather.getInfocode().equals("10000")){
            if (!weather.getLives().isEmpty()) return weather.getLives().get(0);
        }
        return new WeatherChildren();
    }

    private static String getWeatherRealTime(String adcode) {
        // 这里参数顺序要按照字母开头的先后顺序来，不然会报错
        String params = "city=" + adcode + "&extensions=base&key=" + key + privateKey;
        String text = "extensions=base&key=" + key + "&city=" + adcode;
        String sign = MD5Util.getEncryptCode(params);
        String url = weatherApi + text + "&sig=" + sign;
        return OkHttpUtil.getClient(url);
    }

    private static String getGeoCode(String address) {
        String params = "address=" + address + "&key=" + key + privateKey;
        String text = "key=" + key + "&address=" + address;
        String sign = MD5Util.getEncryptCode(params);
        String url = geocodeApi + text + "&sig=" + sign;
        return OkHttpUtil.getClient(url);
    }

}
