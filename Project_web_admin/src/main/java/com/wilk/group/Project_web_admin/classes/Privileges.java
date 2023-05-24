package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "privileges")
public class Privileges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "privileges", nullable = false)
    private String privileges;

    @Column(name = "privileges_int", nullable = false)
    private String privileges_int;
}
