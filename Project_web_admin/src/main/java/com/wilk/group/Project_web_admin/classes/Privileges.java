package com.wilk.group.Project_web_admin.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private int privileges_int;

    @OneToMany(mappedBy = "privileges", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany
    private List<Router> routers;

    @OneToMany
    private List<Server> servers;

    public void addAdmin(){
        this.id= 1L;
        this.privileges="admin";
        this.privileges_int=1;
    }
    public void addUser(){
        this.id= 2L;
        this.privileges="user";
        this.privileges_int=2;
    }
}