package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Users;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Boolean isCredentialValid(String username, String password, final boolean isAdmin){
        final Users user = userRepository.findByUsername(username);
        if (user == null){
            return null;
        }
        else if(user.getPassword().equals(password) && user.getIsadmin() == isAdmin){
            return true;
        }
        else
            return false;
    }
    @Transactional
    public Long findIdByUsernameAndPassword(String username, String password){
        return userRepository.findIdByUsernameAndPassword(username,password);
    }
}
