package com.andres.curso.springboot.error.springboot_error.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {

    @GetMapping("/app")
    public String index() {
        int value = Integer.parseInt("10");
        System.out.println(value);
        return "ok 200";
    }
}
