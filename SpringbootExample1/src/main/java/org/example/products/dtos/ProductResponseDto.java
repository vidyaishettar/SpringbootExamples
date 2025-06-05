package org.example.products.dtos;

import org.example.products.models.ProductDetails;

public class ProductResponseDto {
    private String status;
    private ProductDetails productDetails;




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }
}
