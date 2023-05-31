package com.wilk.group.Project_web_admin.services;

import com.wilk.group.Project_web_admin.classes.Role;
import com.wilk.group.Project_web_admin.classes.User;
import com.wilk.group.Project_web_admin.classes.UserDto;
import com.wilk.group.Project_web_admin.repository.RoleRepository;
import com.wilk.group.Project_web_admin.repository.UserRepository;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) throws Exception{
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkExist("ROLE_ADMIN");
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
        //NewUserFtpDir("/G/Users/"+user.getLogin());
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkExist(String test){
        Role role = new Role();
        role.setId(2L);
        role.setName("ROLE_USER");
        if(test=="ROLE_ADMIN"){
            role.setId(1L);
            role.setName("ROLE_ADMIN");
        }
        return roleRepository.save(role);
    }
    @Autowired
    FtpService ftpService;
    public void NewUserFtpDir(String path) throws Exception {
        ftpService.ftpSetAll("192.168.0.1", 21, "admin", "Testujemy-12345");
        FTPClient ftpClient = ftpService.loginFtp();
        ftpClient.makeDirectory(path);
    }
}