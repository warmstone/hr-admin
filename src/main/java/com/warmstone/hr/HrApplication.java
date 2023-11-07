package com.warmstone.hr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author warmstone
 * @date 2023/11/7 21:38
 * @description
 */
@SpringBootApplication
@MapperScan(basePackages = "com.warmstone.hr.mapper")
public class HrApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }
}
