package com.wilk.group.Project_web_admin.controller;

import com.wilk.group.Project_web_admin.classes.Privileges;
import com.wilk.group.Project_web_admin.classes.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrivilegesRepository extends JpaRepository<Privileges, Long> {
    Privileges findByPrivileges(String privileges);
}
