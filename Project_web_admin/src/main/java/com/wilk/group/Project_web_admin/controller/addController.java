package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.classes.*;

import com.wilk.group.Project_web_admin.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/admin")
    public String admin(){
        return "admin_panel";
    }
    @GetMapping(path = "admin/addServer")
    public String server(Model model) {
        model.addAttribute("server", new Server());
        return "add/add_server";
    }
    @PostMapping(value = "admin/addServer/save")
    public String addServer(@Valid @ModelAttribute("server") Server server, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add/add_server";
        }else {
            serverRepository.save(server);
            return "redirect:/admin/addServer?success";
        }
    }
    @GetMapping(path = "admin/addRouter")
    public String router(Model model) {
        model.addAttribute("router", new Router());
        return "add/add_router";
    }
    @PostMapping(value = "admin/addRouter/save")
    public String addRouter(@Valid @ModelAttribute("router") Router router, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add/add_router";
        }else {
            routerRepository.save(router);
            return "redirect:/admin/addRouter?success";
        }
    }
    @GetMapping(path = "admin/addVpn")
    public String vpn(Model model) {
        model.addAttribute("vpn", new Vpn());
        return "add/add_vpn";
    }
    @PostMapping(value = "admin/addVpn/save")
    public String addVpn(@Valid @ModelAttribute("vpn") Vpn vpn, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add/add_vpn";
        }else {
            vpnRepository.save(vpn);
            return "redirect:/admin/addVpn?success";
        }
    }
    @GetMapping(path = "admin/addRdp")
    public String rdp(Model model) {
        model.addAttribute("rdp", new Rdp());
        return "add/add_rdp";
    }
    @PostMapping(value = "admin/addRdp/save")
    public String addRdp(@Valid @ModelAttribute("rdp") Rdp rdp, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add/add_rdp";
        }else {
            rdpRepository.save(rdp);
            return "redirect:/admin/addRdp?success";
        }
    }
    @GetMapping(path = "admin/addFtp_data")
    public String ftp_data(Model model) {
        model.addAttribute("ftp_data", new Ftp_data());
        return "add/add_ftp_data";
    }
    @PostMapping(value = "admin/addFtp_data/save")
    public String addFtp_data(@Valid @ModelAttribute("ftp_data") Ftp_data ftp_data, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add/add_ftp_data";
        }else {
            ftp_dataRepository.save(ftp_data);
            return "redirect:/admin/addFtp_data?success";
        }
    }
    @GetMapping(path = "admin/addData_base")
    public String data_base(Model model) {
        model.addAttribute("data_base", new Data_base());
        return "add/add_data_base";
    }
    @PostMapping(value = "admin/addData_base/save")
    public String addData_base(@Valid @ModelAttribute("data_base") Data_base data_base, BindingResult errors, Model model) throws Exception {
        if (errors.hasErrors()) {
            return "add/add_data_base";
        }else {
            databaseRepository.save(data_base);
            return "redirect:/admin/addData_base?success";
        }
    }
}
