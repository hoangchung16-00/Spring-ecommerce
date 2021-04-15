package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface UserRepository extends JpaRepository<Users,Long> {

}
