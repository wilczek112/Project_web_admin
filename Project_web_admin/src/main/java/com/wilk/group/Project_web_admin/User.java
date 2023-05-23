package com.wilk.group.Project_web_admin;

import jakarta.persistence.*;
import lombok.*;

    @Getter
    @Setter
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        private Integer id;

        @Column(name = "login", nullable = false, unique = true, length = 32)
        private String login;

        @Column(name = "password", nullable = false, length = 64)
        private String password;

        @Column(name = "email", nullable = false, unique = true, length = 32)
        private String email;

        @Column(name = "privileges", nullable = false, length = 8)
        private String privileges;
    }