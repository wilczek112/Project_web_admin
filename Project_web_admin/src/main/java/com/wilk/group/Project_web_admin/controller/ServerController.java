package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.classes.Server;
import com.wilk.group.Project_web_admin.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServerController {
    @Autowired
    private ServerRepository serverRepository;
    


    @GetMapping(path = "/servers")
    public String getServers(Model model){
        List<Server> servers = serverRepository.findAll();
        List<Server> serverUser = new ArrayList<>();
        for(int i=0;i<servers.size();i++){
            //System.out.println(servers.get(i).getPrivileges());
            //if(servers.get(i).getPrivileges()==2) serverUser.add(servers.get(i));
        }
        int who=1;
        if(who==0) model.addAttribute("servery",servers);
        if(who==1) model.addAttribute("servery", serverUser);
        return "html/serwer";
    }
//    @GetMapping(path = "/getServers")
//    public @ResponseBody Iterable<Server> getServers(){
//        //model.addAttribute("servery", serverRepository.findAll());
//        return serverRepository.findAll();
//    }

}
