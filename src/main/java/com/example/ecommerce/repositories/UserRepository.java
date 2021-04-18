package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);

    @Query("select u.id from Users u where u.username = ?1 and u.password= ?2")
    Long findUserIdByUsernameAndPassword(String username, String password);
}
