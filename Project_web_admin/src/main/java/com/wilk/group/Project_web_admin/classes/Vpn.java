package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "vpn")
public class Vpn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "protocole", nullable = false)
    private String ftp_path;

    @Column(name = "ip_address", nullable = false)
    private String ip_address;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "key", nullable = true)
    private String key;

    @Column(name = "priveleges_id", nullable = false)
    private Long priveleges_id;
}