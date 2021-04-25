package com.example.ecommerce.services;

import com.example.ecommerce.entitys.MyUserDetails;
import com.example.ecommerce.entitys.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    private Map<String, User> roles = new HashMap<>();

    @PostConstruct
    public void init() {
        String role;
        for (Users user : userService.findAll()){
            if(user.getIsadmin())
                role = "ADMIN";
            else
                role="USER";
            roles.put(user.getUsername(), new User(user.getUsername(), "{noop}"+user.getPassword(), getAuthority(role)));
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }
    private List<GrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
