package com.wilk.group.Project_web_admin.controller;


import com.wilk.group.Project_web_admin.classes.Ftp_data;
import com.wilk.group.Project_web_admin.classes.Ftp_file_database;
import com.wilk.group.Project_web_admin.classes.Role;
import com.wilk.group.Project_web_admin.classes.User;
import com.wilk.group.Project_web_admin.repository.Ftp_dataRepository;
import com.wilk.group.Project_web_admin.repository.RoleRepository;
import com.wilk.group.Project_web_admin.repository.UserRepository;
import com.wilk.group.Project_web_admin.services.UserService;
import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
@Controller
public class ftpController {

    @Autowired
    private Ftp_dataRepository ftp_dataRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    ArrayList<Ftp_file_database> ftp_file_database = new ArrayList<Ftp_file_database>();
    public void Ftp_dataController(String path) throws Exception {
        Ftp_data ftp = ftp_dataRepository.findByName("Domyślny");
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(ftp.getIp_address(), Integer.parseInt(ftp.getPort()));
        ftpClient.login(ftp.getLogin(), ftp.getPassword());

        long i=0;
        for (FTPFile ftpFile : ftpClient.listFiles(path)) {
            if (ftpFile.isDirectory()) {
                Ftp_file_database ftp_file_database2 = new Ftp_file_database();
                ftp_file_database2.setId(i); ftp_file_database2.setFile_type("directory");
                  ftp_file_database2.setName(ftpFile.getName());
                  ftp_file_database.add(ftp_file_database2);
                  i++;
            }
        }
        for (FTPFile ftpFile : ftpClient.listFiles(path)) {
            if (ftpFile.isFile()) {
                Ftp_file_database ftp_file_database2 = new Ftp_file_database();
                ftp_file_database2.setId(i); ftp_file_database2.setFile_type("file");
                ftp_file_database2.setName(ftpFile.getName());
                ftp_file_database.add(ftp_file_database2);
                i++;
            }
        }
        ftpClient.disconnect();
    }
    @RequestMapping(path="/panel/ftp")
    public String servers(Model model) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = new User();
        user = userService.findUserByEmail(currentPrincipalName);
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        String path;
        if (hasUserRole==true) path="/G/";
        else path="/G/Users/"+user.getLogin();
        ftp_file_database.clear();
        Ftp_dataController(path);
        model.addAttribute("files_database", ftp_file_database);
        return "ftp";
    }










}
