package org.example.products.repositories;

import org.example.products.dtos.ProductDetailsDto;
import org.example.products.models.BrandDetails;
import org.example.products.models.ProductDetails;
import org.example.products.dtos.ProductResponseDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    public ProductResponseDto createProduct(ProductDetailsDto details)
    {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductName(details.getProductName());
        productDetails.setProductQuantity(details.getProductQuantity());

        BrandDetails brandDetails = new BrandDetails();
        brandDetails.setName(details.getProductBrandName());

        Configuration config = new Configuration();
        config.addAnnotatedClass(BrandDetails.class);
        config.addAnnotatedClass(ProductDetails.class);
        config.configure("Hibernate.cfg.xml");

        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(brandDetails);
       productDetails.setBrandDetails(brandDetails);
        session.persist(productDetails);

        tx.commit();



      ProductResponseDto productResponseDto = new ProductResponseDto();
      productResponseDto.setStatus("success");
      return productResponseDto;
    }

    public ProductResponseDto fetchProduct(String brandName, String status)
    {
        if (brandName.equalsIgnoreCase("dell"))
        {
            ProductResponseDto productResponseDto = new ProductResponseDto();
//            productResponseDto.setProductName("xyz");
//            productResponseDto.setBrandName("dell");
//            productResponseDto.setPrice(600.00f);
            productResponseDto.setStatus("success");
            return productResponseDto;
        }
        else
        {
            ProductResponseDto productResponseDto = new ProductResponseDto();
//            productResponseDto.setProductName("wipe");
//            productResponseDto.setBrandName("puma");
//            productResponseDto.setPrice(100.00f);
            productResponseDto.setStatus("success");
            return productResponseDto;
        }

    }

    public ProductResponseDto updateProduct(String brandName, String status)
    {
        ProductResponseDto productResponseDto = new ProductResponseDto();
//        productResponseDto.setBrandName("Addidas");
        productResponseDto.setStatus("fail");
        return productResponseDto;
    }

}
