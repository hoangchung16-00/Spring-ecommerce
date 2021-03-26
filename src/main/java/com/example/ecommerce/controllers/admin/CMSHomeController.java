package com.example.ecommerce.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CMSHomeController {
    @GetMapping("cms/home")
    public String getCMSHome(){
        return "cms/home";
    }
}
