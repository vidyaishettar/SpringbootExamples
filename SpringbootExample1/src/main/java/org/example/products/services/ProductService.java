package org.example.products.services;

import org.example.products.dtos.ProductDetailsDto;
import org.example.products.models.ProductDetails;
import org.example.products.dtos.ProductResponseDto;
import org.example.products.repositories.ProductRepository;
import org.example.products.repositories.ProductRepositoryJPAIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductRepositoryJPAIntf productRepositoryJPAIntf;


    public ProductResponseDto createProduct( ProductDetailsDto details)
    {
        ProductResponseDto productResponseDto = productRepository.createProduct(details);
        return productResponseDto;

    }
//    public ProductResponseDto fetchProduct(String brandName, String status)
//    {
//        ProductResponseDto productResponseDto = productRepository.fetchProduct(brandName,status);
//        return productResponseDto;
//    }

    public ProductResponseDto updateProduct(String brandName,String status)
    {
        ProductResponseDto productResponseDto = productRepository.updateProduct(brandName,status);
        return productResponseDto;
    }

    public ProductResponseDto fetchProduct(Integer id)
    {
        Optional<ProductDetails> product = productRepositoryJPAIntf.findById(id);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductDetails(product.get());
        productResponseDto.setStatus("success");
        return productResponseDto;

    }
}
