package com.security.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KeyCloakController {

    @GetMapping("/admin")
    public ResponseEntity<String>getAdmin(){
        return ResponseEntity.ok("Hello Admin");
    }
    @GetMapping("/user")
    public ResponseEntity<String>getUser(){
        return ResponseEntity.ok("Hello User");
    }
}
