package org.example.order.controllers;

import org.example.order.dtos.OrderDetailsDto;
import org.example.order.dtos.OrderResponseDetailsDto;
import org.example.order.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/orders")
public class OrderControllers {
    @Autowired
    OrderServices orderServices;

    @PostMapping("/create")
    public @ResponseBody OrderResponseDetailsDto checkOut(@RequestBody OrderDetailsDto detailsDto)
    {
        OrderResponseDetailsDto orderResponseDetailsDto = orderServices.checkOut(detailsDto);
        return orderResponseDetailsDto;
    }

}



