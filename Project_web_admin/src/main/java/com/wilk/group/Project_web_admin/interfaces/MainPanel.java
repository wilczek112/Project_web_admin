package com.wilk.group.Project_web_admin.interfaces;


import com.wilk.group.Project_web_admin.classes.Server;
import com.wilk.group.Project_web_admin.repository.ServerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.AbstractList;
import java.util.List;

@Controller
public class MainPanel {

    @RequestMapping(path = "/main")
    public String serwer_model(Model model){
                //model.addAttribute("server", serverRepository.findAll());
        return null;
    }
}
