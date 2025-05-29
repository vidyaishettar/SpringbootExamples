package org.example.products.dtos;

import jakarta.persistence.*;
import org.example.products.models.BrandDetails;


public class ProductDetailsDto {

    private Integer id;
    private String productName;
    private String productQuantity;
    private String productBrandName;


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

    public String getProductBrandName() {
        return productBrandName;
    }

    public void setProductBrandName(String productBrandName) {
       this.productBrandName = productBrandName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
}
