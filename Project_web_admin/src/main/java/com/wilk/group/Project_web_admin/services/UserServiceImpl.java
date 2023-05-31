package com.wilk.group.Project_web_admin.services;

import com.wilk.group.Project_web_admin.classes.Privileges;
import com.wilk.group.Project_web_admin.classes.User;
import com.wilk.group.Project_web_admin.classes.UserDto;
import com.wilk.group.Project_web_admin.repository.PrivilegesRepository;
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
    private PrivilegesRepository privilegesRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PrivilegesRepository privilegesRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.privilegesRepository = privilegesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) throws Exception{
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Privileges privileges = privilegesRepository.findByPrivileges("USER");
        if(privileges == null){
            privileges = checkExist("ADMIN");
        }
        user.setPrivilegesList(Arrays.asList(privileges));
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
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Privileges checkExist(String test){
        Privileges privileges = new Privileges();
        privileges.setId(2L);
        privileges.setPrivileges("USER");
        privileges.setPrivileges_int(2);
        if(test=="ADMIN"){
            privileges.setId(1L);
            privileges.setPrivileges("ADMIN");
            privileges.setPrivileges_int(1);
        }
        return privilegesRepository.save(privileges);
    }
    @Autowired
    FtpService ftpService;
    public void NewUserFtpDir(String path) throws Exception {
        ftpService.ftpSetAll("192.168.0.1", 21, "admin", "Testujemy-12345");
        FTPClient ftpClient = ftpService.loginFtp();
        ftpClient.makeDirectory(path);
    }
}