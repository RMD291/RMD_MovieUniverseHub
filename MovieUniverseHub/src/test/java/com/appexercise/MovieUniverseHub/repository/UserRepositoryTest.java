package com.appexercise.MovieUniverseHub.repository;

import com.appexercise.MovieUniverseHub.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void ShouldSaveAndFindUser() {
        User user = new User("User", "12345678", "user@mail.com");
        User saved = userRepository.save(user);
        assertThat(saved.getId()).isGreaterThan(0);

        User found  = userRepository.findById(saved.getId()).orElseThrow();
        assertThat(found.getUsername()).isEqualTo("User");
        assertThat(found.getPassword()).isEqualTo("12345678");
        assertThat(found.getEmail()).isEqualTo("user@mail.com");

        userRepository.delete(saved);
    }
}
