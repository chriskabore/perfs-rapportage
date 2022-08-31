package com.kirasoft.perfs.users.repositories;

import com.kirasoft.perfs.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value="SELECT u FROM User u WHERE u.contactInformation.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
