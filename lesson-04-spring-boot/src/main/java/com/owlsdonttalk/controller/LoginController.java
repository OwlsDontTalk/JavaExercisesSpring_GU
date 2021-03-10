package com.owlsdonttalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login_form";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
