package com.gxtna.wtet.utils;

import com.gxtna.wtet.entity.wechat.PushMessage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *   @author gxtna
 *   @date 2022/11/29 下午2:24
 *   @desciption: 微信消息类
 */
@Component
public class WeChatUtil {

    @Value("${wtet.wechatapi.app-id}")
    private String appId;
    @Value("${wtet.wechatapi.secret}")
    private String secret;
    @Value("${wtet.wechatapi.to-user-id}")
    private String toUserId;
    @Value("${wtet.wechatapi.template-id}")
    private String templateId;

    public  String pushMessage(List<PushMessage> messageList){
        WxMpDefaultConfigImpl wxStorage = new WxMpDefaultConfigImpl();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(toUserId)//要推送的用户openid
                .templateId(templateId)//模版id
                //.url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        messageList.forEach(message->{
            templateMessage.addData(new WxMpTemplateData(message.getName(),message.getValue(),message.getColor()));
        });
        try {
           return wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
        return "";
    }

}
