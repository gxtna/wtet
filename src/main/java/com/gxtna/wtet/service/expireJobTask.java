package com.gxtna.wtet.service;

import com.gxtna.wtet.entity.menu.MenuDetail;
import com.gxtna.wtet.entity.weather.WeatherChildren;
import com.gxtna.wtet.entity.wechat.PushMessage;
import com.gxtna.wtet.utils.MenuUtil;
import com.gxtna.wtet.utils.SetMsgUtil;
import com.gxtna.wtet.utils.WeChatUtil;
import com.gxtna.wtet.utils.WeatherUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gxtna
 * @date 2022/11/29 下午3:03
 * @desciption: 定时推送信息
 * // TODO 后续可能会更改成其他定时器
 */
@Service
public class expireJobTask {
    //每天 8 ， 12 ， 7点执行
    @Scheduled(cron = "0 0 8,12,7 * * ? ")
    public void executeJobTask(){
        List<PushMessage> list = setMessageList();
        WeChatUtil.pushMessage(list);
        System.out.println("发了");
    }

    private List<PushMessage> setMessageList(){
        WeatherChildren weather = WeatherUtil.getWeatherData("昌平区 昌平东关");
        List<MenuDetail> details = MenuUtil.searchMenu("火腿");
        List<PushMessage> pushMessages = SetMsgUtil.setMsg(WeatherChildren.class, weather);
        PushMessage menuMessage = new PushMessage().setName("menu").setValue(details.get(0).getName());
        pushMessages.add(menuMessage);
        return pushMessages;
    }
}
