package com.wilk.group.Project_web_admin.controller;


import com.wilk.group.Project_web_admin.classes.UserDto;
import com.wilk.group.Project_web_admin.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "html/index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "html/panel";
    }

    // handler method to handle user registration request

}
