package org.example.order.model;

import jakarta.persistence.*;
import org.example.cart.models.Cart;

@Entity
@Table ( name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cart_details_id",referencedColumnName = "id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "payment_details_id",referencedColumnName = "id")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
