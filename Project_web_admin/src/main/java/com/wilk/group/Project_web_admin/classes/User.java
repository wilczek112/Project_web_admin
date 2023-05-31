package com.wilk.group.Project_web_admin.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.validation.*;

import java.util.ArrayList;
import java.util.List;


    @Getter
    @Setter
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "login", nullable = false, unique = true, length = 32)
        private String login;

        @Column(name = "password", nullable = false, length = 64)
        private String password;

        @Column(name = "email", nullable = false, unique = true, length = 32)
        private String email;

        @Column(name = "ftp_path", nullable = false)
        private String ftp_path;

        @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
        @JoinTable(
                name="users_privileges",
                joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
                inverseJoinColumns={@JoinColumn(name="privileges_id", referencedColumnName="id")})
        private List<Privileges> privilegesList = new ArrayList<>();
    }

