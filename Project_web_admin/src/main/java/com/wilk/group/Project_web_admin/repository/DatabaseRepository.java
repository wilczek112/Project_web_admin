package com.wilk.group.Project_web_admin.repository;


import com.wilk.group.Project_web_admin.classes.Data_base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseRepository extends JpaRepository<Data_base, Long> {

}