package org.example.cart.controllers;

import jakarta.websocket.server.PathParam;
import org.example.cart.dtos.cartDetails;
import org.example.cart.dtos.CartResponseDto;
import org.example.cart.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/cart")
public class cartControllers
{
    @Autowired
    CartService cartService;

    @PostMapping("/create")
    public @ResponseBody CartResponseDto addItem(@RequestBody cartDetails details)
    {
        System.out.println("Item added successfully");
        CartResponseDto cartResponseDto = cartService.addItem(details);
        return cartResponseDto;
    }

    @GetMapping("/{itemId}")
    public @ResponseBody CartResponseDto fetchItem(@PathVariable("itemId") Long itemId)

    {
        CartResponseDto cartResponseDto = cartService.fetchItem(itemId);
        return cartResponseDto;
    }
}
