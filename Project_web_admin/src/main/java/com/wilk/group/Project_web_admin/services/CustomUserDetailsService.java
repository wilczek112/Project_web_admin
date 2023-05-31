package com.wilk.group.Project_web_admin.services;


import com.wilk.group.Project_web_admin.classes.Privileges;
import com.wilk.group.Project_web_admin.classes.User;
import com.wilk.group.Project_web_admin.repository.PrivilegesRepository;
import com.wilk.group.Project_web_admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private PrivilegesRepository privilegesRepository;
    private Privileges privileges;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(), mapRolesToAuthorities(user.getPrivilegesList()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Privileges> privilegesCollection) {
        Collection < ? extends GrantedAuthority> mapRoles = privilegesCollection.stream()
                .map(privileges -> new SimpleGrantedAuthority(privileges.getPrivileges()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}