package com.andres.curso.springboot.error.springboot_error.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {

    @GetMapping("/app")
    public String index() {
        int value = 100 / 0;
        return "ok 200";
    }
}
