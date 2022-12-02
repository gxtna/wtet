package com.gxtna.wtet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.gxtna.wtet.mapper")
public class WtetApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtetApplication.class, args);
    }

}
