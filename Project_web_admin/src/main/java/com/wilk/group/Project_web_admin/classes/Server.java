package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "server")
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 32)
    private String name;

    @Column(name = "ip_address", nullable = false, length = 64)
    private String ip_address;

    @Column(name = "login", nullable = false, unique = true, length = 32)
    private String login;

    @Column(name = "password", nullable = false, length = 8)
    private String password;
}
