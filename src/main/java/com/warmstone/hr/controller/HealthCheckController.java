package com.warmstone.hr.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author warmstone
 * @date 2023/11/8 22:25
 * @description
 */
@RequestMapping(value = "/healthCheck")
public class HealthCheckController {

    @GetMapping(value = "/health")
    public String health() {
        return "ok";
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456"));
    }
}
