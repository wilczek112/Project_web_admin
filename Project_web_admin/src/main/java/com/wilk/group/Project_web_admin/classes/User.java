package com.wilk.group.Project_web_admin.classes;

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
        @jakarta.validation.constraints.NotBlank(message = "Musisz wpisac swój login")
        @jakarta.validation.constraints.Size(min=3, max = 32,  message = "Login musi zajmować od 5 do 15 znaków")
        private String login;

        @Column(name = "password", nullable = false, length = 64)
        @jakarta.validation.constraints.NotBlank(message = "Hasło jest wymagane")
        @jakarta.validation.constraints.Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_-]).{6,64})"
                , message = "Hasło musi się składać z dużych i małych liter oraz zawierać znaki specjalne")
        private String password;

        @Column(name = "email", nullable = false, unique = true, length = 32)
        @jakarta.validation.constraints.NotBlank(message = "Musisz podać swój email")
        @jakarta.validation.constraints.Email(message = "Email został źle wprowadzony")
        private String email;

        @Column(name = "privileges", nullable = false, length = 8)
        private String privileges;
    }
