package com.example.cac_final.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/test")
public class PruebaController {

    @GetMapping
    public String saludar() {
        return "Hola mundo";
    }
}
