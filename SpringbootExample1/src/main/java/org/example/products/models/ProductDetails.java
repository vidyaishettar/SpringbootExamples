package org.example.products.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String productName;

    @Column(name = "quantity")
    private String productQuantity;

    @OneToOne
    @JoinColumn(name= "brand_details_id",referencedColumnName = "id")
    private BrandDetails brandDetails;

   //private String productBrandName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public String getProductBrandName() {
//        return productBrandName;
//    }
//
//    public void setProductBrandName(String productBrandName) {
//        this.productBrandName = productBrandName;
//    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BrandDetails getBrandDetails() {
        return brandDetails;
    }

    public void setBrandDetails(BrandDetails brandDetails) {
        this.brandDetails = brandDetails;
    }
}
