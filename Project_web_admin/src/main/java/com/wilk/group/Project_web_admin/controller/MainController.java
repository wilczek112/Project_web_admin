package com.wilk.group.Project_web_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller // This means that this class is a Controller

public class MainController {

    @RequestMapping(path="/")
    public String index() {
        return "html/index";
    }

    @RequestMapping(path="/home")
    public String home(){
        return "html/panel";

    }
    @RequestMapping(path="/router")
    public String router(){
        return "html/router";
    }
}