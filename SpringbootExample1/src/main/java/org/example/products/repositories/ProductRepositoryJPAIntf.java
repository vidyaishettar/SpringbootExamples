package org.example.products.repositories;

import org.example.products.models.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPAIntf extends JpaRepository<ProductDetails,Integer> {
}
