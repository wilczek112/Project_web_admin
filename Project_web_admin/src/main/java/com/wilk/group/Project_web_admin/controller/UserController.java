package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.repository.UserRepository;
import com.wilk.group.Project_web_admin.classes.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @RequestMapping(path = "/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "html/register";
    }

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(value = "/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User newUser, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "html/register";
        }else {
            newUser.setPrivileges("user");
            userRepository.save(newUser);
            return "/html/index";
        }
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
