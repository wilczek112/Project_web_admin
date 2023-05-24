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

import java.util.ArrayList;
import java.util.List;

@Controller
public class FtpController {

    @Autowired
    FtpRepository ftpRepository;

    List<Ftp> ftpki = ftpRepository.findAll();

    List<Ftp_file_database> ffd = new ArrayList<>();

//    public FtpController() throws Exception {
//        Ftp_file_database ftp_file_database = new Ftp_file_database();
//        FTPClient ftpClient = new FTPClient();
//        ftpClient.connect("192.168.0.1", 21);
//        ftpClient.login("visit", "Witaj12345678");
//        long i=0;
//        for (FTPFile ftpFile : ftpClient.listFiles(ftps.get(0).getFtp_path())) {
//            if (ftpFile.isDirectory()) {
//                ftp_file_database.setId(i); ftp_file_database.setFile_type("directory");
//                  ftp_file_database.setName(ftpFile.getName());
//                  ffd.add(ftp_file_database);
//                  i++;
//            }
//        }
//        for (FTPFile ftpFile : ftpClient.listFiles(ftps.get(0).getFtp_path())) {
//            if (ftpFile.isFile()) {
//                ftp_file_database.setId(i); ftp_file_database.setFile_type("file");
//                ftp_file_database.setName(ftpFile.getName());
//                ffd.add(ftp_file_database);
//                i++;
//            }
//        }
//    }

//    @GetMapping(path = "/ftp")
//    public String getServers(Model model){
//        //model.addAttribute("ftp", ffd);
//        //System.out.println(ftps.get(1));
//        return "html/ftp";
//    }
//    @GetMapping(path = "/getServers")
//    public @ResponseBody Iterable<Server> getServers(){
//        //model.addAttribute("servery", serverRepository.findAll());
//        return serverRepository.findAll();
//    }

//    @RequestMapping(path="/ftp")
//    public String servers(){
//        return "html/ftp";
//    }







}
