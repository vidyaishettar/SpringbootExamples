package org.example.users.controllers;

import org.example.users.dtos.AuthenticationResponse;
import org.example.users.models.User;
import org.example.users.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/users")
public class UserControllers {

    @Autowired
    UserServices userServices;

    @GetMapping
    public @ResponseBody AuthenticationResponse findByPhonenumber(@RequestParam(name="phonenumber") String phonenumber)
    {
        AuthenticationResponse authenticationResponse = userServices.findByPhonenumber(phonenumber);
        return authenticationResponse;
    }
}
