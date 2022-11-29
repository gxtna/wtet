package com.gxtna.wtet.controller;


import com.gxtna.wtet.entity.wechat.PushMessage;
import com.gxtna.wtet.utils.WeChatUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sendMsg")
public class sendMessageController {

    // todo 注册微信开发平台账号 发送真是的推送信息
    @GetMapping("/push")
    public void push() {
        PushMessage pushMessage1 = new PushMessage().setName("order").setValue("炸鸡可乐").setColor("#FF00FF");
        PushMessage pushMessage2 = new PushMessage().setName("Weather").setValue("大雨转小雨，太阳很大").setColor("##FF00FF\"");
        List<PushMessage> list = new ArrayList<>();
        list.add(pushMessage1);
        list.add(pushMessage2);
        System.out.println(WeChatUtil.pushMessage(list));
    }
}
