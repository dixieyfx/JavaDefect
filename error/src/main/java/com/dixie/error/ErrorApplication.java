package com.dixie.error;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2024/3/16 11:15
 */
@SpringBootApplication
@EnableWebMvc
public class ErrorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErrorApplication.class,args);
    }
}
