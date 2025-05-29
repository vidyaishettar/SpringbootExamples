package org.example.users.repositories;

import org.example.users.dtos.AuthenticationDto;
import org.example.users.dtos.AuthenticationResponse;
import org.example.users.models.Profile;
import org.example.users.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationRepository {
    public AuthenticationResponse login(AuthenticationDto input)
    {
        //actual db operator to be done here

        AuthenticationResponse response = new AuthenticationResponse();
        response.setStatus("success");
        User user = new User();
        user.setName("vidya");
        user.setPhoneNumber("2565652653");
        response.setUser(user);
        return response;
    }

    public AuthenticationResponse signup(AuthenticationDto input)
    {
        AuthenticationResponse response = new AuthenticationResponse();
        User U = new User();
       U.setPhoneNumber(input.getPhoneNumber());
       U.setEmail(input.getEmail());
        U.setName(input.getName());

        Profile P = new Profile();
        P.setAbout(" ");


        Configuration config = new Configuration();
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Profile.class);
                config.configure("Hibernate.cfg.xml");


        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(P);
        U.setProfile(P);
        session.persist(U);

        tx.commit();
        return response;
    }
}
