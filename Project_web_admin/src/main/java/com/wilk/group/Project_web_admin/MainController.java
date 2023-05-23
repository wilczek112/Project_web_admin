package com.wilk.group.Project_web_admin;

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
        CurrentWeather currentWeather = new CurrentWeather("Clear", BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN);
        model.addAttribute("currentWeather", currentWeather);
        return "html/panel";
    }
}