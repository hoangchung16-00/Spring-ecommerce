package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    private Map<String, User> roles = new HashMap<>();
    @PostConstruct
    public void init(){
        for (Users user : userService.findAll()){
            if(user.getIsadmin()){
                roles.put(user.getUsername(),new User(user.getUsername(),"{noop}"+user.getPassword(),getAuthority("ADMIN")));
            } else {
                roles.put(user.getUsername(),new User(user.getUsername(),"{noop}"+user.getPassword(),getAuthority("USER")));
            }
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        return roles.get(username);
    }

    private List<GrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

}
