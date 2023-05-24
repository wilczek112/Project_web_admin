package com.wilk.group.Project_web_admin.repository;


import com.wilk.group.Project_web_admin.classes.Date_base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseRepository extends JpaRepository<Date_base, Long> {

}