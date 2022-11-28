package com.gxtna.wtet.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {

    public String getEncryptCode(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
