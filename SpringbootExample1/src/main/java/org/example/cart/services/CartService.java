package org.example.cart.services;

import org.example.cart.dtos.cartDetails;
import org.example.cart.dtos.CartResponseDto;
import org.example.cart.repositories.CartRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepositories cartRepositories;

    public CartResponseDto addItem(cartDetails details)
    {
        CartResponseDto cartResponseDto = cartRepositories.addItem(details);
        return cartResponseDto;
    }

    public CartResponseDto fetchItem(Long itemid)
    {
        CartResponseDto cartResponseDto = cartRepositories.fetchItem(itemid);
        return cartResponseDto;
    }

}
