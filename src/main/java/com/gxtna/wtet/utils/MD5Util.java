package com.gxtna.wtet.utils;

import org.springframework.util.DigestUtils;

/**
 *   @author gxtna
 *   @date 2022/11/29 下午2:24
 *   @desciption: MD5 加密类
 */
public class MD5Util {

    public static String getEncryptCode(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
