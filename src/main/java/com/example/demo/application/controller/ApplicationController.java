package com.example.demo.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
//@RequestMapping("/api/v1/hello")
public class ApplicationController {

    @GetMapping("/hello")
    public ResponseEntity<String> securedHello() {
        return ResponseEntity.ok("Hello, this is secured!");
    }
}
