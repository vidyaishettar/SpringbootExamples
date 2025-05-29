package org.example.cart.repositories;

import org.example.cart.dtos.CartResponseDto;
import org.example.cart.dtos.cartDetails;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositories {

    public CartResponseDto addItem(cartDetails details)
    {
       //actual db insert query happens here
       //input to query is data coming from client i.e details
       //
        CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setProductName(cartResponseDto.getProductName());
        cartResponseDto.setBrandName(cartResponseDto.getBrandName());
        cartResponseDto.setStatus("success");
        return cartResponseDto;
    }

    public CartResponseDto fetchItem(Long itemId)
    {
        if(itemId == 6)
        {
            CartResponseDto cartResponseDto = new CartResponseDto();
            cartResponseDto.setProductName("laptop");
            cartResponseDto.setBrandName("puma");
            cartResponseDto.setStatus("success");
            return cartResponseDto;
        }
        else
        {
            CartResponseDto cartResponseDto = new CartResponseDto();
            cartResponseDto.setProductName("phone");
            cartResponseDto.setBrandName("iphone");
            cartResponseDto.setStatus("success");
            return cartResponseDto;
        }
    }

}
