package com.aldomarassolin.blog_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Blog API!";
    }

    @GetMapping("/home")
    public String MyHome(){
        return "Outra rota";
    }
}
