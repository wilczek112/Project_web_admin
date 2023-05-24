package com.wilk.group.Project_web_admin;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.*;


    @Getter
    @Setter
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "login", nullable = false, unique = true, length = 32)
        @jakarta.validation.constraints.Size(min=5, max = 15,  message = "Login musi zajmować od 5 do 15 znaków")
        @jakarta.validation.constraints.NotEmpty(message = "Musisz wpisac swój login")
        private String login;

        @Column(name = "password", nullable = false, length = 64)
        @jakarta.validation.constraints.Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{6,20})",
                message = "Hasło jest błędne")
        @jakarta.validation.constraints.NotEmpty(message = "Hasło jest wymagane")
        private String password;

        @Column(name = "email", nullable = false, unique = true, length = 32)
        @jakarta.validation.constraints.NotEmpty(message = "Musisz podać swój email")
        @jakarta.validation.constraints.Email(message = "Email został źle wprowadzony")
        private String email;

        @Column(name = "privileges", nullable = false, length = 8)
        @jakarta.validation.constraints.NotEmpty
        private String privileges;
    }
