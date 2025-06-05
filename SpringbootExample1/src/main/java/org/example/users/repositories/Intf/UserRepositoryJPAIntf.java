package org.example.users.repositories.Intf;

import org.example.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJPAIntf extends JpaRepository <User,Integer> {

    //select * from user where phonenumber = "976576788"
    Optional<User> findByPhoneNumber(String phoneNumber);


}
