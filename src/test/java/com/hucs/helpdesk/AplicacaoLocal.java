package com.hucs.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoLocal {

    public static void main(String[] args) throws Exception {
        System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(HelpdeskApplication.class, args);
     }

}