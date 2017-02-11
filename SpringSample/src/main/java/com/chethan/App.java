package com.chethan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by chethanshetty on 11/02/17.
 */
@EnableAutoConfiguration
@ComponentScan("com.chethan")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
