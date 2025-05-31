package org.example.cart.models;

import jakarta.persistence.*;
import org.example.products.models.ProductDetails;

@Entity
@Table ( name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float price;

    @ManyToOne
    @JoinColumn(name = "cart_details_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_details_id", referencedColumnName = "id")
    private ProductDetails productDetails;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }
}
