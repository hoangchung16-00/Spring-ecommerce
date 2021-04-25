package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.entitys.MyUserDetails;
import com.example.ecommerce.entitys.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CMSHomeController {
    @GetMapping("cms/home")
    public String getCMSHome(){
        return "cms/home";
    }
}
