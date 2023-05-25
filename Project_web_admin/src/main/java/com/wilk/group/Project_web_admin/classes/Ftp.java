package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "ftp")
public class Ftp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ftp_path", nullable = false)
    private String ftp_path;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne(mappedBy = "ftp")
    private User user;
}
