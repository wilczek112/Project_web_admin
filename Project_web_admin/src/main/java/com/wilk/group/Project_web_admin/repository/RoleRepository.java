package com.wilk.group.Project_web_admin.repository;

import com.wilk.group.Project_web_admin.classes.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
