package org.example.users.services;

import org.example.users.dtos.AuthenticationDto;
import org.example.users.dtos.AuthenticationResponse;
import org.example.users.repositories.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService
{
    //@autowired will create object automatically. this is called as dependancy injection
    @Autowired
    AuthenticationRepository authenticationRepository;
    public AuthenticationResponse login(AuthenticationDto input)
    {
        //perform any logical operation and call repository function
        //AuthenticationRepository AR = new AuthenticationRepository();
        AuthenticationResponse response = authenticationRepository.login(input);
        return response;

    }

    public AuthenticationResponse signup(AuthenticationDto input)
    {
        AuthenticationResponse response = authenticationRepository.signup(input);
        return response;
    }
}
