package com.andres.curso.springboot.error.springboot_error.controller;

import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.andres.curso.springboot.error.springboot_error.models.domain.User;
import com.andres.curso.springboot.error.springboot_error.services.UserService;
import com.andres.curso.springboot.error.springboot_error.services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index() {
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario no existe"));
        System.out.println(user.getLastname());
        return user;
    }

}
