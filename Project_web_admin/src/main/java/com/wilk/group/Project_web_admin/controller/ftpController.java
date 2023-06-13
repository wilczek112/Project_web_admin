package com.wilk.group.Project_web_admin.controller;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
public class ftpController {

//    @Autowired
//    private Ftp_dataRepository ftp_dataRepository;
//    List<Ftp_file_database> ftp_file_database = new ArrayList<>();
//    public Ftp_dataController() throws Exception {
//        List<Ftp_data> ftp_dataList = ftp_dataRepository.findAll();
//        Ftp_file_database ftp_file_database2 = new Ftp_file_database();
//        FTPClient ftpClient = new FTPClient();
//        ftpClient.connect("192.168.0.1", 21);
//        ftpClient.login("tak", "tak12345");
//        long i=0;
//        for (FTPFile ftpFile : ftpClient.listFiles("/G/")) {
//            if (ftpFile.isDirectory()) {
//                ftp_file_database2.setId(i); ftp_file_database2.setFile_type("d");
//                  ftp_file_database2.setName(ftpFile.getName());
//                  ftp_file_database.add(ftp_file_database2);
//                  i++;
//            }
//        }
//        for (FTPFile ftpFile : ftpClient.listFiles("/G/")) {
//            if (ftpFile.isFile()) {
//                ftp_file_database2.setId(i); ftp_file_database2.setFile_type("f");
//                ftp_file_database2.setName(ftpFile.getName());
//                ftp_file_database.add(ftp_file_database2);
//                i++;
//            }
//        }
//    }
    @RequestMapping(path="/panel/ftp")
    public String servers(){
        return "html/ftp";
    }

    @GetMapping(path = "/panel/ftpshow")
    public String getServers(Model model){

        //model.addAttribute("files_database", ftp_file_database);
        //System.out.println(ftps.get(1));
        return "html/ftp";
    }
//    @GetMapping(path = "/getServers")
//    public @ResponseBody Iterable<Server> getServers(){
//        //model.addAttribute("servery", serverRepository.findAll());
//        return serverRepository.findAll();
//    }









}
