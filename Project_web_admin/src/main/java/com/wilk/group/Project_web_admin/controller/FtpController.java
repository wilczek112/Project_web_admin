package com.wilk.group.Project_web_admin.controller;


import com.wilk.group.Project_web_admin.classes.Ftp;
import com.wilk.group.Project_web_admin.classes.Ftp_file_database;
import com.wilk.group.Project_web_admin.interfaces.FtpService;
import com.wilk.group.Project_web_admin.repository.FtpRepository;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FtpController {

    @Autowired
    FtpRepository ftpRepository;

    //List<Ftp> ftpki = ftpRepository.findAll();

    List<Ftp_file_database> ftp_file_database = new ArrayList<>();

    public FtpController() throws Exception {
        Ftp_file_database ftp_file_database2 = new Ftp_file_database();
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.0.1", 21);
        ftpClient.login("visit", "Witaj12345678");
        long i=0;
        for (FTPFile ftpFile : ftpClient.listFiles("/G/")) {
            if (ftpFile.isDirectory()) {
                ftp_file_database2.setId(i); ftp_file_database2.setFile_type("d");
                  ftp_file_database2.setName(ftpFile.getName());
                  ftp_file_database.add(ftp_file_database2);
                  i++;
            }
        }
        for (FTPFile ftpFile : ftpClient.listFiles("/G/")) {
            if (ftpFile.isFile()) {
                ftp_file_database2.setId(i); ftp_file_database2.setFile_type("f");
                ftp_file_database2.setName(ftpFile.getName());
                ftp_file_database.add(ftp_file_database2);
                i++;
            }
        }
    }
    @RequestMapping(path="/ftp")
    public String servers(){
        return "html/ftp";
    }

    @GetMapping(path = "/ftpshow")
    public String getServers(Model model){

        model.addAttribute("files_database", ftp_file_database);
        //System.out.println(ftps.get(1));
        return "html/ftp";
    }
//    @GetMapping(path = "/getServers")
//    public @ResponseBody Iterable<Server> getServers(){
//        //model.addAttribute("servery", serverRepository.findAll());
//        return serverRepository.findAll();
//    }









}
