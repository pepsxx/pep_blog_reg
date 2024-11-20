package ru.pepsxx.pep_blog_reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pepsxx.pep_blog_reg.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

     Optional<User> findFirstByEmail(String email);
}
