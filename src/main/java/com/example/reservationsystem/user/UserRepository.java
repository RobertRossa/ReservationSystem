package com.example.reservationsystem.user;

import com.example.reservationsystem.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByFirstName(String email);
    User findByEmail (String email);

}
