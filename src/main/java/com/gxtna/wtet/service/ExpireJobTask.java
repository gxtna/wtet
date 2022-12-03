package com.gxtna.wtet.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gxtna.wtet.entity.RecipeRecord;
import com.gxtna.wtet.entity.recipe.RecipeDetail;
import com.gxtna.wtet.entity.weather.WeatherChildren;
import com.gxtna.wtet.entity.wechat.PushMessage;
import com.gxtna.wtet.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author gxtna
 * @date 2022/11/29 下午3:03
 * @desciption: 定时推送信息
 * // TODO 后续可能会更改成其他定时器
 */
@Service
public class ExpireJobTask {


    @Autowired
    WeatherUtil weatherUtil;
    @Autowired
    RecipeUtil menuUtil;
    @Autowired
    WeChatUtil weChatUtil;
    @Autowired
    RecipeUtil recipeUtil;
    @Autowired
    RecipeRecordService recipeRecordService;

    //每天 8 ， 12 ， 7点执行
    //@Scheduled(cron = "0 0 8,12,7 * * ? ")
    @Scheduled(cron = "0/10 * * * * ? ")
    public void executeJobTask() {
        List<PushMessage> list = setMessageList();
        String s = weChatUtil.pushMessage(list);
        System.out.println(s);
    }

    // TODO 虚假的菜谱推荐，后续要根据算法来返回菜谱
    private List<PushMessage> setMessageList() {
        WeatherChildren weather = weatherUtil.getWeatherData("北京市 昌平区");
        String season = DateTimeUtil.getSeason();
        List<RecipeRecord> recordList = recipeRecordService.getBaseMapper().selectList(new LambdaQueryWrapper<RecipeRecord>()
                .eq(RecipeRecord::getSeasonId, season));
        //  随机从list中获取一个数据返回
        int nextInt = ThreadLocalRandom.current().nextInt(recordList.size());
        String recipeName = recordList.get(nextInt).getRecipeName();
        List<RecipeDetail> details = menuUtil.searchMenu(recipeName);
        List<PushMessage> pushMessages = SetMsgUtil.setMsg(WeatherChildren.class, weather);
        PushMessage menuMessage = new PushMessage().setName("menu").setValue(details.get(0).getName());
        pushMessages.add(menuMessage);
        return pushMessages;
    }


}
