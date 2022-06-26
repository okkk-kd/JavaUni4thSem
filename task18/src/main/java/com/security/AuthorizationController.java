package com.security;

import com.service.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthorizationController {
    private ApplicationUserService applicationUserService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("")
    public String getIndexPage() {
        return "index.html";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") AppUser user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String signUpUser(@ModelAttribute("user") AppUser user) {
        return applicationUserService.signUpUser(user);
    }
}
