package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.classes.Privileges;
import com.wilk.group.Project_web_admin.classes.Router;
import com.wilk.group.Project_web_admin.repository.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

@Controller
class DatabaseCleanController{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    PrivilegesRepository privilegesRepository;
    @Autowired
    RouterRepository routerRepository;
    @Autowired
    RdpRepository rdpRepository;
    @Autowired
    FtpRepository ftpRepository;
    @Autowired
    DatabaseRepository databaseRepository;

    @RequestMapping(path="/destroy")
    public String destroy(){
        userRepository.deleteAll();
        serverRepository.deleteAll();
        privilegesRepository.deleteAll();
        routerRepository.deleteAll();
        rdpRepository.deleteAll();
        ftpRepository.deleteAll();
        databaseRepository.deleteAll();
        return "redirect:/";
    }
}