package com.basseifer.orcamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/index")
    public String teste(){
        System.out.println("Acessando o INDEX");
        return "Testando";
    }
}
