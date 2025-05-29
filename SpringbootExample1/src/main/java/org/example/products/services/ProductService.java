package org.example.products.services;

import org.example.products.dtos.ProductDetailsDto;
import org.example.products.models.ProductDetails;
import org.example.products.dtos.ProductResponseDto;
import org.example.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public ProductResponseDto createProduct( ProductDetailsDto details)
    {
        ProductResponseDto productResponseDto = productRepository.createProduct(details);
        return productResponseDto;

    }
    public ProductResponseDto fetchProduct(String brandName, String status)
    {
        ProductResponseDto productResponseDto = productRepository.fetchProduct(brandName,status);
        return productResponseDto;
    }

    public ProductResponseDto updateProduct(String brandName,String status)
    {
        ProductResponseDto productResponseDto = productRepository.updateProduct(brandName,status);
        return productResponseDto;
    }
}
