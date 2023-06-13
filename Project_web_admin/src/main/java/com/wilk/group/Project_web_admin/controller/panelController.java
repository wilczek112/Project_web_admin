package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.classes.Server;
import com.wilk.group.Project_web_admin.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class panelController {
    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private DatabaseRepository databaseRepository;

    @Autowired
    private RdpRepository rdpRepository;

    @Autowired
    private RouterRepository routerRepository;

    @Autowired
    private VpnRepository vpnRepository;
    @GetMapping(path = "/panel/vpn")
    public String getVpn(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        List<com.wilk.group.Project_web_admin.classes.Vpn> vpns = vpnRepository.findAll();
        List<com.wilk.group.Project_web_admin.classes.Vpn> vpnUser = new ArrayList<>();
        for(int i=0;i<vpns.size();i++){
            if(vpns.get(i).getRole_id()==2) vpnUser.add(vpns.get(i));
        }

        if(hasUserRole==true) model.addAttribute("vpn",vpns);
        else model.addAttribute("vpn", vpnUser);
        return "vpn";
    }
    //    @GetMapping(path = "/getServers")
//    public @ResponseBody Iterable<Server> getServers(){
//        //model.addAttribute("servery", serverRepository.findAll());
//        return serverRepository.findAll();
//    }
    @GetMapping(path = "/panel/routers")
    public String getRouters(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        List<com.wilk.group.Project_web_admin.classes.Router> routers = routerRepository.findAll();
        List<com.wilk.group.Project_web_admin.classes.Router> routersUser = new ArrayList<>();
        for (int i = 0; i < routers.size(); i++) {
            if (routers.get(i).getRole_id() == 2) routersUser.add(routers.get(i));
        }

        if (hasUserRole == true) model.addAttribute("routers", routers);
        else model.addAttribute("routers", routersUser);
        return "router";
    }
    @GetMapping(path = "/panel/rdp")
    public String getRdp(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        List<com.wilk.group.Project_web_admin.classes.Rdp> rdps = rdpRepository.findAll();
        List<com.wilk.group.Project_web_admin.classes.Rdp> rdpUser = new ArrayList<>();
        for(int i=0;i<rdps.size();i++){
            if(rdps.get(i).getRole_id()==2) rdpUser.add(rdps.get(i));
        }

        if(hasUserRole==true) model.addAttribute("rdps",rdps);
        else model.addAttribute("rdps", rdpUser);
        return "rdp";
    }
//    @GetMapping(path = "/getServers")
//    public @ResponseBody Iterable<Server> getServers(){
//        //model.addAttribute("servery", serverRepository.findAll());
//        return serverRepository.findAll();
//    }

    @GetMapping(path = "/panel/database")
    public String getDataBase(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        List<com.wilk.group.Project_web_admin.classes.Data_base> dataBases = databaseRepository.findAll();
        List<com.wilk.group.Project_web_admin.classes.Data_base> dataBaseUser = new ArrayList<>();
        for(int i=0;i<dataBases.size();i++){
            if(dataBases.get(i).getRole_id()==2) dataBaseUser.add(dataBases.get(i));
        }

        if(hasUserRole==true) model.addAttribute("dataBases",dataBases);
        else model.addAttribute("dataBases", dataBaseUser);
        return "database";
    }

    @GetMapping(path = "/panel/servers")
    public String getServers(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        List<Server> servers = serverRepository.findAll();
        List<Server> serverUser = new ArrayList<>();
        for(int i=0;i<servers.size();i++){
            if(servers.get(i).getRole_id()==2) serverUser.add(servers.get(i));
        }

        if(hasUserRole==true) model.addAttribute("servery",servers);
        else model.addAttribute("servery", serverUser);
        return "serwer";
    }
//    @GetMapping(path = "/getServers")
//    public @ResponseBody Iterable<Server> getServers(){
//        //model.addAttribute("servery", serverRepository.findAll());
//        return serverRepository.findAll();
//    }

}
