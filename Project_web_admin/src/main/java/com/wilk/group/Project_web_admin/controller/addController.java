package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.classes.Vpn;
import com.wilk.group.Project_web_admin.classes.Rdp;
import com.wilk.group.Project_web_admin.classes.Ftp_data;
import com.wilk.group.Project_web_admin.classes.Data_base;
import com.wilk.group.Project_web_admin.classes.Router;
import com.wilk.group.Project_web_admin.classes.Server;

import com.wilk.group.Project_web_admin.repository.*;
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
    @Autowired
    RouterRepository routerRepository;
    @Autowired
    VpnRepository vpnRepository;
    @Autowired
    RdpRepository rdpRepository;
    @Autowired
    Ftp_dataRepository ftp_dataRepository;
    @Autowired
    DatabaseRepository databaseRepository;
    @GetMapping(path = "/addServer")
    public String server(Model model) {
        model.addAttribute("server", new Server());
        return "add_server";
    }
    @PostMapping(value = "/addServer/save")
    public String addServer(@Valid @ModelAttribute("server") Server server, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add_server";
        }else {
            serverRepository.save(server);
            return "redirect:/addServer?success";
        }
    }
    @GetMapping(path = "/addRouter")
    public String router(Model model) {
        model.addAttribute("router", new Router());
        return "add_router";
    }
    @PostMapping(value = "/addRouter/save")
    public String addRouter(@Valid @ModelAttribute("router") Router router, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add_router";
        }else {
            routerRepository.save(router);
            return "redirect:/addRouter?success";
        }
    }
    @GetMapping(path = "/addVpn")
    public String vpn(Model model) {
        model.addAttribute("vpn", new Vpn());
        return "add_vpn";
    }
    @PostMapping(value = "/addVpn/save")
    public String addVpn(@Valid @ModelAttribute("vpn") Vpn vpn, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add_vpn";
        }else {
            vpnRepository.save(vpn);
            return "redirect:/addVpn?success";
        }
    }
    @GetMapping(path = "/addRdp")
    public String rdp(Model model) {
        model.addAttribute("rdp", new Rdp());
        return "add_rdp";
    }
    @PostMapping(value = "/addRdp/save")
    public String addRdp(@Valid @ModelAttribute("rdp") Rdp rdp, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add_rdp";
        }else {
            rdpRepository.save(rdp);
            return "redirect:/addRdp?success";
        }
    }
    @GetMapping(path = "/addFtp_data")
    public String ftp_data(Model model) {
        model.addAttribute("ftp_data", new Ftp_data());
        return "add_ftp_data";
    }
    @PostMapping(value = "/addFtp_data/save")
    public String addFtp_data(@Valid @ModelAttribute("ftp_data") Ftp_data ftp_data, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add_ftp_data";
        }else {
            ftp_dataRepository.save(ftp_data);
            return "redirect:/addFtp_data?success";
        }
    }
    @GetMapping(path = "/addData_base")
    public String data_base(Model model) {
        model.addAttribute("data_base", new Data_base());
        return "add_data_base";
    }
    @PostMapping(value = "/addData_base/save")
    public String addData_base(@Valid @ModelAttribute("data_base") Data_base data_base, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add_data_base";
        }else {
            databaseRepository.save(data_base);
            return "redirect:/addData_base?success";
        }
    }
}
