package io.krish.learning;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.krish.learning.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
