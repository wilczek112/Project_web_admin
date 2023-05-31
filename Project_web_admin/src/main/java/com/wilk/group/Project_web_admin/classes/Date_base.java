package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "data_base")
public class Date_base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ip_address", nullable = false)
    private String ip_address;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "privleges_id", nullable = false)
    private int priveleges_id;
}