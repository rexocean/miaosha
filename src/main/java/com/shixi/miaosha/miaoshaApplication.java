package com.shixi.miaosha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.shixi.miaosha")
@MapperScan("com.shixi.miaosha.dao")
public class miaoshaApplication {
    public static void main(String[] args) {
        SpringApplication.run(miaoshaApplication.class, args);
    }
}
