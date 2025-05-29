package org.example.users.dtos;

import org.example.users.models.User;

public class AuthenticationResponse {
    private String status;
    private User user;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
