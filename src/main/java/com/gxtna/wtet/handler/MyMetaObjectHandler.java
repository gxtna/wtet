package com.gxtna.wtet.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.gxtna.wtet.utils.DateTimeUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @author gxtna
 * @date 2022/12/2 下午3:24
 * @desciption: 字段自动填充类
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final LocalDateTime localDateTime = DateTimeUtil.formatLocalDateTime(DateTimeUtil.formatString(LocalDateTime.now()));
    @Override
    public void insertFill(MetaObject metaObject) {

        this.strictInsertFill(metaObject, "createTime",()->localDateTime , LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updateTime",()->localDateTime, LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", ()->localDateTime, LocalDateTime.class);
    }
}
