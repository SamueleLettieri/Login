package com.jaita120.reporitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jaita120.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);
}
