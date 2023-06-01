package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.classes.Server;

import com.wilk.group.Project_web_admin.repository.ServerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class addController {
    @Autowired
    ServerRepository serverRepository;
    @GetMapping(path = "/addServer")
    public String register(Model model) {
        model.addAttribute("server", new Server());
        return "add_server";
    }
    @PostMapping(value = "/addServer/save")
    public String saveUser(@Valid @ModelAttribute("server") Server server, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add_server";
        }else {
            serverRepository.save(server);
            return "redirect:/addServer?success";
        }
    }
}
