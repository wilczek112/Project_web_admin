package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "privileges")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Privileges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "privileges", nullable = false)
    private String privileges;

    @Column(name = "privileges_int", nullable = false)
    private int privileges_int;

    @ManyToMany(mappedBy = "privilegesList")
    private List<User> users;
}