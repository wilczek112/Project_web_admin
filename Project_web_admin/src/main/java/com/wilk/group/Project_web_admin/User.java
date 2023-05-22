package com.wilk.group.Project_web_admin;

import jakarta.persistence.*;
import lombok.*;

    @Getter
    @Setter
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @Column(nullable = false, unique = true, length = 32)
        private String login;

        @Column(nullable = false, length = 64)
        private String password;

        @Column(nullable = false, unique = true, length = 32)
        private String email;

        @Column(name = "privileges", nullable = false, length = 8)
        private String privileges;
    }
