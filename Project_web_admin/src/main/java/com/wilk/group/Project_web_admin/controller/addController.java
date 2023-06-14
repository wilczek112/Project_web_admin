package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.classes.*;

import com.wilk.group.Project_web_admin.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/admin/editServer/{id}")
    public String editServer(@PathVariable("id") long id, Model model) {
        Server server = serverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid server Id:" + id));
        model.addAttribute("servers", server);
        return "edit/edit_server";
    }
    @PostMapping("/admin/updateServer/{id}")
    public String updateServer(@PathVariable("id") long id, @Valid Server server,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            server.setId(id);
            return "edit/edit_server";
        }
        serverRepository.save(server);
        return "redirect:/panel/server";
    }
    @GetMapping("/admin/deleteServer/{id}")
    public String deleteServer(@PathVariable("id") long id, Model model) {
        Server server = serverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        serverRepository.delete(server);
        return "redirect:/panel/server";
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
    @GetMapping("/admin/editRouter/{id}")
    public String editRouter(@PathVariable("id") long id, Model model) {
        Router router = routerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid router Id:" + id));
        model.addAttribute("routers", router);
        return "edit/edit_router";
    }
    @PostMapping("/admin/updateRouter/{id}")
    public String updateRouter(@PathVariable("id") long id, @Valid Router router,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            router.setId(id);
            return "edit/edit_router";
        }
        routerRepository.save(router);
        return "redirect:/panel/router";
    }
    @GetMapping("/admin/deleteRouter/{id}")
    public String deleteRouter(@PathVariable("id") long id, Model model) {
        Router router = routerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        routerRepository.delete(router);
        return "redirect:/panel/router";
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
    @GetMapping("/admin/editVpn/{id}")
    public String editVpn(@PathVariable("id") long id, Model model) {
        Vpn vpn = vpnRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vpn Id:" + id));
        model.addAttribute("vpn", vpn);
        return "edit/edit_vpn";
    }
    @PostMapping("/admin/updateVpn/{id}")
    public String updateVpn(@PathVariable("id") long id, @Valid Vpn vpn,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            vpn.setId(id);
            return "edit/edit_vpn";
        }
        vpnRepository.save(vpn);
        return "redirect:/panel/vpn";
    }
    @GetMapping("/admin/deleteVpn/{id}")
    public String deleteVpn(@PathVariable("id") long id, Model model) {
        Vpn vpn = vpnRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        vpnRepository.delete(vpn);
        return "redirect:/panel/vpn";
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
    @GetMapping("/admin/editRdp/{id}")
    public String editRdp(@PathVariable("id") long id, Model model) {
        Rdp rdp = rdpRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rdp Id:" + id));
        model.addAttribute("rdp", rdp);
        return "edit/edit_rdp";
    }
    @PostMapping("/admin/updateRdp/{id}")
    public String updateRdp(@PathVariable("id") long id, @Valid Rdp rdp,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            rdp.setId(id);
            return "edit/edit_rdp";
        }
        rdpRepository.save(rdp);
        return "redirect:/panel/rdp";
    }
    @GetMapping("/admin/deleteRdp/{id}")
    public String deleteRdp(@PathVariable("id") long id, Model model) {
        Rdp rdp = rdpRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        rdpRepository.delete(rdp);
        return "redirect:/panel/rdp";
    }    @GetMapping(path = "admin/addFtp_data")
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
    @GetMapping("/admin/editFtp_data/{id}")
    public String editFtp_data(@PathVariable("id") long id, Model model) {
        Ftp_data ftp_data = ftp_dataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ftp_data Id:" + id));
        model.addAttribute("ftp_data", ftp_data);
        return "edit/edit_ftp_data";
    }
    @PostMapping("/admin/updateFtp_data/{id}")
    public String updateFtp_data(@PathVariable("id") long id, @Valid Ftp_data ftp_data,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            ftp_data.setId(id);
            return "edit/edit_ftp_data";
        }
        ftp_dataRepository.save(ftp_data);
        return "redirect:/admin/ftpdata";
    }
    @GetMapping("/admin/deleteFtp_data/{id}")
    public String deleteFtp_data(@PathVariable("id") long id, Model model) {
        Ftp_data ftp_data = ftp_dataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        ftp_dataRepository.delete(ftp_data);
        return "redirect:/admin/ftpdata";
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
    @GetMapping("/admin/editData_base/{id}")
    public String editData_base(@PathVariable("id") long id, Model model) {
        Data_base data_base = databaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid data_base Id:" + id));
        model.addAttribute("data_base", data_base);
        return "edit/edit_data_base";
    }
    @PostMapping("/admin/updateData_base/{id}")
    public String updateData_base(@PathVariable("id") long id, @Valid Data_base data_base,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            data_base.setId(id);
            return "edit/edit_data_base";
        }
        databaseRepository.save(data_base);
        return "redirect:/panel/database";
    }
    @GetMapping("/admin/deleteData_base/{id}")
    public String deleteData_base(@PathVariable("id") long id, Model model) {
        Data_base data_base = databaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        databaseRepository.delete(data_base);
        return "redirect:/panel/database";
    }
}
