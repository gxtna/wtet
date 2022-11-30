package com.gxtna.wtet.utils;

import com.gxtna.wtet.entity.wechat.PushMessage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gxtna
 * @date 2022/11/29 下午4:15
 * @desciption: 设置消息体的工具类
 */
public class SetMsgUtil {

    public static List<PushMessage> setMsg(Class<?> sourceData, Object data) {
        List<PushMessage> list = new ArrayList<>();
        try {
            Field[] declaredFields = sourceData.getDeclaredFields();
            Field[] dataFields = data.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                for (Field dataField : dataFields) {
                    dataField.setAccessible(true);
                    if (field.getName().equals(dataField.getName())){
                        PushMessage pushMessage = new PushMessage();
                        String value = String.valueOf(dataField.get(data)).replaceAll("T"," ");
                        pushMessage.setName(field.getName());
                        pushMessage.setValue(value);
                        list.add(pushMessage);
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
