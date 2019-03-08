package com.english;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.english.entity")
@MapperScan("com.english.mapper")
public class EnglishApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnglishApplication.class, args);
    }

}
