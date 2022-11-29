package com.gxtna.wtet.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Objects;

/**
 * @author gxtna
 * @date 2022/11/29 下午1:50
 * @desciption: OkHttpUtil 工具类
 */
public class OkHttpUtil {

    static OkHttpClient client = new OkHttpClient();

    public static String getClient(String url){
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
}
