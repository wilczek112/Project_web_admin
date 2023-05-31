package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "dane_ftp")
public class Ftp_data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ftp_name", nullable = false)
    private String ftp_name;

    @Column(name = "ip_address", nullable = false)
    private String ip_address;

    @Column(name = "status", nullable = false)
    private String status;

}