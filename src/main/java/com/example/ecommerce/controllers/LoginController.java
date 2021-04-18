package com.example.ecommerce.controllers;

import com.example.ecommerce.controllers.client.BaseExtender;
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
public class LoginController extends BaseExtender {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String getLogin(Model model, HttpSession session){

        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
    @PostMapping("login")
    public String postLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model, HttpSession session){
        if(bindingResult.hasErrors()){
            return "login";
        }
        if (userService.isCredentialValid(loginForm.getUsername(),loginForm.getPassword(),true)){
            Long userId = userService.findUserIdByUsernameAndPassword(loginForm.getUsername(),loginForm.getPassword());
            session.setAttribute("userId", userId);
            return "cms/home";
        }
        else if (userService.isCredentialValid(loginForm.getUsername(),loginForm.getPassword(),false)){
            Long userId = userService.findUserIdByUsernameAndPassword(loginForm.getUsername(),loginForm.getPassword());
            session.setAttribute("userId", userId);
            return "index";
        }
        model.addAttribute("message", "Username or Password incorrect");
        return "login";
    }
}
