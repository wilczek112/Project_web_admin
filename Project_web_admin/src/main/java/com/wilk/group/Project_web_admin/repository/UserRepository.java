package com.wilk.group.Project_web_admin.repository;

import com.wilk.group.Project_web_admin.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

}