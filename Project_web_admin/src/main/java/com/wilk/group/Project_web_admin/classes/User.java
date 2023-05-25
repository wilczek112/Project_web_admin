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
        @Size(min=3,max=32, message = "Login musi zawierać od 3 do 32 znaków.")
        private String login;

        @Column(name = "password", nullable = false, length = 64)
        @Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_-]).{6,64})", message = "Hasło musi składać się z dużych i małych liter, cyfr oraz znaklów specjalnych. Dopuszczalna długość to 6-64 znaków.")
        private String password;

        @Column(name = "email", nullable = false, unique = true, length = 32)
        @NotBlank(message = "Pole nie może być puste")
        @Email(message = "Niepoprawny email")
        private String email;

        @OneToOne
        @JoinColumn(name="ftp_id")
        private Ftp ftp;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="privileges")
        private Privileges privileges;

        public User(Privileges privileges){
            this.privileges=privileges;
        }
    }

