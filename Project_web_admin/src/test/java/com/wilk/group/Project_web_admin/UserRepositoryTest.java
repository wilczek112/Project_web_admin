package com.wilk.group.Project_web_admin;

import com.wilk.group.Project_web_admin.classes.User;
import com.wilk.group.Project_web_admin.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;
    @Test
    public void testCreateUser() {
        //privileges.addUser(user);
        User user = new User();
        user.setLogin("user");
        user.setPassword("user");
        user.setEmail("null@test.pl");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
    // test methods go below
}