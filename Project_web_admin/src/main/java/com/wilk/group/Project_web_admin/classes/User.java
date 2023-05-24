package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
        @Size(min=3,max=32)
        private String login;

        @Column(name = "password", nullable = false, length = 64)
        //@Size(min=6,max=64)
        @Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_-]).{6,64})", message = "Zjebałeś hasło")
//        @jakarta.validation.constraints.Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_-]).{6,64})"
//                , message = "Hasło musi się składać z dużych i małych liter oraz zawierać znaki specjalne")
        private String password;

        @Column(name = "email", nullable = false, unique = true, length = 32)
        @NotBlank(message = "Zjebałeś email")
        @Email(message = "Zjebałeś email")
        private String email;

        @Column(name = "privileges", nullable = false, length = 8)
        private String privileges;
    }
