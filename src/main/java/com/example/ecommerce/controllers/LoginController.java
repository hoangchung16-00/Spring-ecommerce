package com.example.ecommerce.controllers;

import com.example.ecommerce.controllers.client.BaseExtender;
import com.example.ecommerce.entities.Users;
import com.example.ecommerce.forms.LoginForm;

import com.example.ecommerce.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController extends BaseExtender {
//    private static final Logger log = LogManager.getLogger(LoginController.class);
//
//    @GetMapping(value = "login")
//    public String login(Model model) {
//        model.addAttribute("loginForm", new LoginForm());
//        return "login";
//    }
//
//    @GetMapping(value = "/loginFailed")
//    public String loginError(Model model) {
//        log.info("Login attempt failed");
//        model.addAttribute("error", "true");
//        return "login";
//    }
//
//    @GetMapping(value = "/logout")
//    public String logout(SessionStatus session) {
//        SecurityContextHolder.getContext().setAuthentication(null);
//        session.setComplete();
//        return "redirect:/login";
//    }
//
//    @PostMapping(value = "/login")
//    public String postLogin(Model model, HttpSession session) {
//        log.info("postLogin()");
//
//        // read principal out of security context and set it to session
//        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        validatePrinciple(authentication.getPrincipal());
//        Users loggedInUser = ((PdfUserDetails) authentication.getPrincipal()).getUserDetails();
//
//        model.addAttribute("currentUser", loggedInUser.getUsername());
//        session.setAttribute("userId", loggedInUser.getId());
//        return "redirect:/cms/home";
//    }
//
//    private void validatePrinciple(Object principal) {
//        if (!(principal instanceof PdfUserDetails)) {
//            throw new  IllegalArgumentException("Principal can not be null!");
//        }
//    }
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
    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
}
