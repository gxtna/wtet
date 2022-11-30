package com.gxtna.wtet.utils;

import com.google.gson.Gson;
import com.gxtna.wtet.entity.menu.MenuDetail;
import com.gxtna.wtet.entity.menu.MenuRoot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class MenuUtil {

    @Value("${wtet.jdapi.key}")
    private String key;
    @Value("${wtet.jdapi.api}")
    private String api;
    @Value("${wtet.jdapi.number}")
    private String number;



    public List<MenuDetail> searchMenu(String keyword){
        String url = api+"/search?num="+number+"&appkey="+key+"&keyword="+keyword;
        String data = OkHttpUtil.getClient(url);
        return getResultData(data);
    }

     // todo 这里目前只写了一种普通的查询，后续如果有需要在继续增加


    private List<MenuDetail> getResultData(String data){
        Gson gson = new Gson();
        MenuRoot menuRoot = gson.fromJson(data, MenuRoot.class);
        if (Objects.nonNull(menuRoot) && menuRoot.getMsg().equals("查询成功")){
            if (Objects.nonNull(menuRoot.getResult()) && menuRoot.getResult().getMsg().equals("ok")){
                return menuRoot.getResult().getResult().getList();
            }
        }
        return new ArrayList<>();
    }
}
