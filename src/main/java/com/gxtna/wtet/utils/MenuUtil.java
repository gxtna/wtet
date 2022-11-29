package com.gxtna.wtet.utils;

import com.google.gson.Gson;
import com.gxtna.wtet.entity.menu.MenuDetail;
import com.gxtna.wtet.entity.menu.MenuRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuUtil {

    private static final String key="3ce37cf3acf72e0eb2beefeef5d34e97";
    private static final String api = "https://way.jd.com/jisuapi";

    private static final int number = 20;

    public static List<MenuDetail> searchMenu(String keyword){
        String url = api+"/search?num="+number+"&appkey="+key+"&keyword="+keyword;
        String data = OkHttpUtil.getClient(url);
        return getResultData(data);
    }

     // todo 这里目前只写了一种普通的查询，后续如果有需要在继续增加


    private static List<MenuDetail> getResultData(String data){
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
