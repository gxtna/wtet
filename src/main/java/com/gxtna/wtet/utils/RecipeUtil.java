package com.gxtna.wtet.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gxtna.wtet.entity.Effect;
import com.gxtna.wtet.entity.RecipeRecord;
import com.gxtna.wtet.entity.recipe.RecipeDetail;
import com.gxtna.wtet.entity.recipe.RecipeRoot;
import com.gxtna.wtet.service.EffectService;
import com.gxtna.wtet.service.RecipeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.*;

@Component
public class RecipeUtil {

    @Value("${wtet.jdapi.key}")
    private String key;
    @Value("${wtet.jdapi.api}")
    private String api;
    @Value("${wtet.jdapi.number}")
    private String number;

    @Autowired
    EffectService effectService;

    @Autowired
    RecipeRecordService recipeRecordService;

    public List<RecipeDetail> searchMenu(String keyword){
        String url = api+"/search?num="+number+"&appkey="+key+"&keyword="+keyword;
        String data = OkHttpUtil.getClient(url);
        return getResultData(data);
    }

    public void getRecipeById(String id){
        String url = api+"/detail?appkey="+key+"&id="+id;
        String data = OkHttpUtil.getClient(url);
        getDetailData(data);
    }

     // todo 这里的思路感觉有问题，需要在修改，包括代码和表

    private void getDetailData(String data){
        Type type = new TypeToken<Map<String,Object>>() {}.getType();
        Gson gson = new Gson();
        Map<String,Object> rootMap = gson.fromJson(data, type);
        if (Objects.nonNull(rootMap) && rootMap.get("msg").equals("查询成功")){
            Map<String,Object> oneMap = gson.fromJson(gson.toJson(rootMap.get("result")), type);
            if (Objects.nonNull(oneMap) && oneMap.get("msg").equals("ok")){
                RecipeDetail detail = gson.fromJson(gson.toJson(oneMap.get("result")), RecipeDetail.class);
                RecipeRecord recipeRecord = new RecipeRecord().setRecipeId(detail.getId()).setRecipeName(detail.getName())
                        .setEffectId(detail.getTag()).setSeasonId(getSeason(detail.getContent()));
                 recipeRecordService.getBaseMapper().insert(recipeRecord);
                insertEffect(detail.getTag());
            }
        }
    }


    private String getSeason(String str){
        String[] val = {"春","夏","秋","冬"};
       Map<String,Integer> map = new HashMap<>();
        for (String c : val) {
            if (str.contains(c)){
                int  count  =  str.length()-str.replaceAll(c,"").length();
                map.put(c,count);
            }
        }
         List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
         list.sort(Comparator.comparingInt(Map.Entry::getValue));
         if (list.isEmpty()) return val[3];
         return list.get(list.size()-1).getKey();
    }

    private void insertEffect(String str){
        String[] split = str.split(",");
        for (String s : split) {
            effectService.saveOrUpdate(new Effect().setEffectName(s).setEffectDesc(s),new LambdaQueryWrapper<Effect>()
                    .eq(Effect::getEffectName,s));
        }
    }
    private List<RecipeDetail> getResultData(String data){
        Gson gson = new Gson();
        RecipeRoot recipeRoot = gson.fromJson(data, RecipeRoot.class);
        if (Objects.nonNull(recipeRoot) && recipeRoot.getMsg().equals("查询成功")){
            if (Objects.nonNull(recipeRoot.getResult()) && recipeRoot.getResult().getMsg().equals("ok")){
                return recipeRoot.getResult().getResult().getList();
            }
        }
        return new ArrayList<>();
    }
}
