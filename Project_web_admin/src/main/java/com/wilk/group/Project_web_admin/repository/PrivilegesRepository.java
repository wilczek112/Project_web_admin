package com.wilk.group.Project_web_admin.repository;

import com.wilk.group.Project_web_admin.classes.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivilegesRepository extends JpaRepository<Privileges, Long> {
    Privileges findByPrivileges(String privileges);
    Optional<Privileges> findById(Long id);
}
