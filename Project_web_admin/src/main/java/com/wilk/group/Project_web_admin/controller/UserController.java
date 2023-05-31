package com.wilk.group.Project_web_admin.controller;


import com.wilk.group.Project_web_admin.classes.UserDto;
import com.wilk.group.Project_web_admin.repository.UserRepository;
import com.wilk.group.Project_web_admin.classes.User;
import com.wilk.group.Project_web_admin.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(path = "/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "html/register";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") UserDto newUser, BindingResult errors, Model model) throws Exception {
        User testLogin = userRepository.findByLogin(newUser.getLogin());
        User testEmail = userRepository.findByEmail(newUser.getEmail());
        if(testLogin != null && testLogin.getLogin() != null && !testLogin.getLogin().isEmpty()){
            errors.rejectValue("login", null,
                    "There is already an account registered with the same login");
        }
        if(testEmail != null && testEmail.getEmail() != null && !testEmail.getEmail().isEmpty()){
            errors.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }
        if (errors.hasErrors()) {
            return "/html/register";
        }else {
            userService.saveUser(newUser);
            return "redirect:register?success";
        }
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
