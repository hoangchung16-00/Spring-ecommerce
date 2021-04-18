package com.example.ecommerce.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CMSHomeController {
    @GetMapping("cms/home")
    public String getCMSHome(HttpSession session){
        if(session.getAttribute("userId")==null){
            return "redirect:/login";
        }
        return "cms/home";
    }
}
