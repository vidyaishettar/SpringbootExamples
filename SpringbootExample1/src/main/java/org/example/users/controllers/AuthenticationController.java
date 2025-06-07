package org.example.users.controllers;

import jakarta.validation.Valid;
import org.example.users.dtos.AuthenticationDto;
import org.example.users.dtos.AuthenticationResponse;
import org.example.users.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public @ResponseBody AuthenticationResponse login(@Valid @RequestBody AuthenticationDto input)
    {
        //System.out.println("login success " +input.getUserName() + " password - " +input.getPassword());
        AuthenticationResponse response = authenticationService.login(input);
        return response;
    }

    @PostMapping("/signup")
    public @ResponseBody AuthenticationResponse signup(@RequestBody AuthenticationDto input)
    {
        System.out.println("signup success " +input.getName());
        AuthenticationResponse response = authenticationService.signup(input);
        return response;
    }
//    @PutMapping
//    public @ResponseBody AuthenticationResponse update(@RequestBody)

}
