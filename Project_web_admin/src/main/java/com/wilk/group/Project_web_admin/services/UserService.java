package com.wilk.group.Project_web_admin.services;

import com.wilk.group.Project_web_admin.classes.User;
import com.wilk.group.Project_web_admin.classes.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto) throws Exception;

    User findUserByLogin(String login);

    List<UserDto> findAllUsers();
}