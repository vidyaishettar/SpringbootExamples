package org.example.users.services;

import org.example.users.dtos.AuthenticationResponse;
import org.example.users.models.User;
import org.example.users.repositories.AuthenticationRepository;
import org.example.users.repositories.Intf.UserRepositoryJPAIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    AuthenticationRepository authenticationRepository;

    @Autowired
    UserRepositoryJPAIntf userRepositoryJPAIntf;

    public AuthenticationResponse findByPhonenumber(String phonenumber)
    {
        Optional<User> user = userRepositoryJPAIntf.findByPhoneNumber(phonenumber);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setUser(user.get());
        authenticationResponse.setStatus("success");
        return authenticationResponse;

    }
}
