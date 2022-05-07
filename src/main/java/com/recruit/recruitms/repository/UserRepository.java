package com.recruit.recruitms.repository;

import com.recruit.recruitms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    List<User> getByName(String name);

    Optional<User> getByEmail(String email);

    Optional<User> getByUsername(String username);
}
