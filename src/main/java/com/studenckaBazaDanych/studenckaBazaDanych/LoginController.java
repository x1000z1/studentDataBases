package com.studenckaBazaDanych.studenckaBazaDanych;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        if (loginService.authenticate(username, password)) {
            return "redirect:/subpages/adminPanel.html";
        } else {
            return "redirect:/index.html?error=true";
        }
    }
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }
}
