package com.gxtna.wtet.controller;


import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMsg")
public class sendMessageController {

    // todo 注册微信开发平台账号 发送真是的推送信息
    @GetMapping("/push")
    public void push() {
        //1，配置
        WxMpDefaultConfigImpl wxStorage = new WxMpDefaultConfigImpl();
        wxStorage.setAppId("wx91c5d504d798066c");
        wxStorage.setSecret("84372ef087cefea35bc7e7d98d37096e");
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("o0Xqa5pNYf_AHr6d_5OxK49e7iSc")//要推送的用户openid
                .templateId("8sCLYnW_kY3ZOEV047wJXFVRwOlX0Mp9gT1ysqE_Hmo")//模版id
                //.url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
               // templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
                templateMessage.addData(new WxMpTemplateData("t","今天是2022年12月36日","#FF00FF"));
                templateMessage.addData(new WxMpTemplateData("order","炸鸡可乐","#FF00FF"));
                templateMessage.addData(new WxMpTemplateData("Weather","大雨转小雨，太阳很大","#FF00FF"));
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }

    }
}
