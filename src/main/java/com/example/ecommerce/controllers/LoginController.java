package com.example.ecommerce.controllers;

import com.example.ecommerce.forms.LoginForm;
import com.example.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "login";
    }
    @GetMapping("/404")
    public String getErrorPage(){
        return "404";
    }

}
