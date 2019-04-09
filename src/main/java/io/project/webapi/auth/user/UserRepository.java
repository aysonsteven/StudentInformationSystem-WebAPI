package io.project.webapi.auth.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByLogin(String login);

    Optional<User> findFirstByLoginAndPassword(String login, String password);
}