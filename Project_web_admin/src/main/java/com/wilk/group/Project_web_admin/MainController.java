package com.wilk.group.Project_web_admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller // This means that this class is a Controller

public class MainController {

    @RequestMapping(path="/index")
    public String index() {
        return "html/index";
    }
//    @Autowired // This means to get the bean called userRepository
//    // Which is auto-generated by Spring, we will use it to handle the data
//    private UserRepository userRepository;
//
//    @GetMapping(path="/register") // Map ONLY POST Requests
//    public String registerForm(Model model) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//        model.addAttribute("user", new User());
//        return "html/register";
//    }
//    @PostMapping("/register")
//    public String registerSubmit(@ModelAttribute User2 user2, Model model){
//        user2.setPrivileges("user");
//        //User user = new User();
//        //userRepository.save();
//        return "result";
//    }


//    @GetMapping(path="/results")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return userRepository.findAll();
//    }
}