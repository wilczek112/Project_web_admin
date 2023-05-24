package com.wilk.group.Project_web_admin.interfaces;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainPanel {
    @RequestMapping(path = "/main")
    public String serwer_model(Model model){
        model.addAttribute("dfh");
        return null;
    }
}
