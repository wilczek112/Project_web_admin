package com.wilk.group.Project_web_admin.repository;


import com.wilk.group.Project_web_admin.classes.Ftp_data;
import com.wilk.group.Project_web_admin.classes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ftp_dataRepository extends JpaRepository<Ftp_data, Long> {
    Ftp_data findByName(String name);

}