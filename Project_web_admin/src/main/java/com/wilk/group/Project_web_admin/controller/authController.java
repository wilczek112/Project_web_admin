package com.wilk.group.Project_web_admin.controller;


import com.wilk.group.Project_web_admin.classes.Server;
import com.wilk.group.Project_web_admin.classes.User;
import com.wilk.group.Project_web_admin.classes.UserDto;
import com.wilk.group.Project_web_admin.repository.ServerRepository;
import com.wilk.group.Project_web_admin.repository.UserRepository;
import com.wilk.group.Project_web_admin.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class authController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ServerRepository serverRepository;
    private UserService userService;

    public authController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String index(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()) return "redirect:/panel";
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/panel";
    }
    @RequestMapping("/panel")
    public String panel(Model model) throws SocketException, UnknownHostException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        User user = new User();
        user = userService.findUserByEmail(currentPrincipalName);
        final DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.connect(InetAddress.getLocalHost(), 12345);
        String host = datagramSocket.getLocalAddress().getHostAddress();
        List<Server> servers = serverRepository.findAll();
        List<Server> serverUser = new ArrayList<>();
        for(int i=0;i<servers.size();i++){
            if(servers.get(i).getRole_id()==2) serverUser.add(servers.get(i));
        }
        if(hasUserRole) model.addAttribute("servery",servers);
        else model.addAttribute("servery", serverUser);
        model.addAttribute("user", user);
        model.addAttribute("host", host);
        return "panel";
    }
    @GetMapping(path = "/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }
    @PostMapping(value = "/register/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") UserDto newUser, BindingResult errors, Model model) throws Exception {
        User testLogin = userRepository.findByLogin(newUser.getLogin());
        User testEmail = userRepository.findByEmail(newUser.getEmail());
        if(testLogin != null && testLogin.getLogin() != null && !testLogin.getLogin().isEmpty()){
            errors.rejectValue("login", null,
                    "Istnieje konto o tym samym loginie");
        }
        if(testEmail != null && testEmail.getEmail() != null && !testEmail.getEmail().isEmpty()){
            errors.rejectValue("email", null,
                    "Istnieje konto o tym samym loginie");
        }
        if (errors.hasErrors()) {
            return "register";
        }else {
            userService.saveUser(newUser);
            return "redirect:/register?success";
        }
    }
    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
