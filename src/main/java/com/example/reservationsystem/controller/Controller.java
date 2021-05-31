package com.example.reservationsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/secured-path")
    public void securedPath() {
    }

    @GetMapping("/admin-only")
    public void adminOnly() {
    }
}
