package org.example.products.controllers;

import org.example.products.dtos.ProductDetailsDto;
import org.example.products.models.ProductDetails;
import org.example.products.dtos.ProductResponseDto;
import org.example.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductControllers {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public @ResponseBody ProductResponseDto createProduct(@RequestBody ProductDetailsDto details)
    {
       System.out.println("Product created successfully");
       ProductResponseDto productResponseDto = productService.createProduct(details);
       return productResponseDto;
    }
    /*@GetMapping("/{productId}")
    public @ResponseBody ProductResponseDto fetchProduct(@PathVariable("productId") Long productId)
    {
        ProductResponseDto productResponseDto = productService.fetchProduct(productId);
        return productResponseDto;
    }*/
    @GetMapping
    //@RequestMapping("/products")
    public @ResponseBody ProductResponseDto fetchProduct(@RequestParam("brandName")  String brandName, @RequestParam("status") String status)
    {
        ProductResponseDto productResponseDto = productService.fetchProduct(brandName,status);
        return productResponseDto;
    }
    @PutMapping
    public ProductResponseDto updateProduct(@RequestParam("brandName")  String brandName, @RequestParam("status") String status)
    {
        ProductResponseDto productResponseDto = productService.updateProduct(brandName,status);
        return productResponseDto;
    }



}
