package com.czt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czt.mapper")
public class MyFirstApp {
    public static void main(String[] args) {
        SpringApplication.run(MyFirstApp.class,args);
    }
}
