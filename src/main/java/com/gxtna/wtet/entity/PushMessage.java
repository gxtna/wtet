package com.gxtna.wtet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author gxtna
 * @date 2022/11/29 下午2:51
 * @desciption: 消息推送的配置类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PushMessage {
    private String name;
    private String value;
    private String color;
}
