package com.gxtna.wtet.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gxtna.wtet.adapter.LocalDateAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WeatherUtil {

    private static final String weatherApi = "https://restapi.amap.com/v3/weather/weatherInfo?";
    private static final String geocodeApi = "https://restapi.amap.com/v3/geocode/geo?";
    private static final String key = "adb0ec0ae1ca02547ffecc4933a64c48";
    private static final String privateKey = "4dfc24bd11c42e201e8625b32e60cb9f";


    /*public Weather getWeatherData(String address){
        String geoCode = getGeoCode(address);
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe()).create();
        Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
        Type listType = new TypeToken<List<Object>>() {}.getType();
        Map<String,Object> map = gson.fromJson(geoCode, mapType);
        String adCode = null;
        if (Objects.nonNull(map) && map.get("infocode").equals("10000")){
            List<Object> list = gson.fromJson(gson.toJson(map.get("geocodes")), listType);
            Map<String,Object> temp = gson.fromJson(gson.toJson(list.get(0)),mapType);
            adCode = String.valueOf(temp.getOrDefault("adcode","110000"));
        }
        String weatherInfo = getWeatherInfo(adCode);
        return gson.fromJson(weatherInfo, Weather.class);
    }*/
    public String getWeatherData(String address){
        String geoCode = getGeoCode(address);
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe()).create();
        Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
        Type listType = new TypeToken<List<Object>>() {}.getType();
        Map<String,Object> map = gson.fromJson(geoCode, mapType);
        String adCode = null;
        if (Objects.nonNull(map) && map.get("infocode").equals("10000")){
            List<Object> list = gson.fromJson(gson.toJson(map.get("geocodes")), listType);
            Map<String,Object> temp = gson.fromJson(gson.toJson(list.get(0)),mapType);
            adCode = String.valueOf(temp.getOrDefault("adcode","110000"));
        }
        String weatherInfo = getWeatherInfo(adCode);
        Map<String,Object> info = gson.fromJson(weatherInfo, mapType);
        if (Objects.nonNull(info) && info.get("infocode").equals("10000")){
           return gson.toJson(info.get("forecasts"));
        }
        return null;
    }

     private String getWeatherInfo(String adcode){
         // 这里参数顺序要按照字母开头的先后顺序来，不然会报错
         String params = "city="+adcode+"&extensions=all&key="+key+privateKey;
         String text = "extensions=all&key="+key+"&city="+adcode;
         String sign=new MD5Util().getEncryptCode(params);
         String url = weatherApi+text+"&sig="+sign;
         return responseData(url);
     }
     private String getGeoCode(String address) {
         String params = "address="+address+"&key="+key+privateKey;
         String text = "key="+key+"&address="+address;
         String sign=new MD5Util().getEncryptCode(params);
         String url = geocodeApi+text+"&sig="+sign;
         return responseData(url);
     }

     private String responseData(String url){
         OkHttpClient client = new OkHttpClient();
         Request request = new Request.Builder()
                 .url(url)
                 .build();
         try {
             Response response = client.newCall(request).execute();
             return Objects.requireNonNull(response.body()).string();
         }catch (Exception e){
             e.printStackTrace();
         }
         return "";
     }

     private String generateSign(String params,String key,String privateKey){
         // privateKey 就是开启数字签名后生成的
         String text = params+"&"+key+privateKey;
        return new MD5Util().getEncryptCode(text);
     }
}