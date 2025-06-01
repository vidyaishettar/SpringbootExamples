package org.example.users.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.example.cart.models.Cart;
import org.example.payment.models.PaymentDetailsModel;

import java.util.List;

@Entity
@Table(name = "user_datails")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name" )
    private String name;
    //private String status;

    @Column(name = "mobile")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<PaymentDetailsModel> paymentDetailsModels;

//    @ManyToOne
//    @JoinColumn(name = "payment_details_id")
//    private PaymentDetailsModel  paymentDetailsModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public List<PaymentDetailsModel> getPaymentDetailsModels() {
        return paymentDetailsModels;
    }

    public void setPaymentDetailsModels(List<PaymentDetailsModel> paymentDetailsModels) {
        this.paymentDetailsModels = paymentDetailsModels;
    }
//    public PaymentDetailsModel getPaymentDetailsModel() {
//        return paymentDetailsModel;
//    }
//
//    public void setPaymentDetailsModel(PaymentDetailsModel paymentDetailsModel) {
//        this.paymentDetailsModel = paymentDetailsModel;
//    }
}
