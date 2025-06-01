package org.example.payment.models;

import jakarta.persistence.*;
import org.example.users.models.User;

import java.util.List;

@Entity
@Table (name = "payment_details")


public class PaymentDetailsModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_datails_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
