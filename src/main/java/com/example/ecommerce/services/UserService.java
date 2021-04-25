package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Users;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<Users> findAll(){
        return userRepository.findAll();
    }
    @Transactional
    public Users findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Transactional
    public Users findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
