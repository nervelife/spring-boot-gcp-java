package com.nervelife.springbootgcpjava.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/private/user/info")
    public Object userInfo(Authentication auth) {
        if (auth !=  null) {
            return auth.getPrincipal();
        }
        return null;
    }
    
}
