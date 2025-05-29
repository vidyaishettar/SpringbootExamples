package org.example.order.services;

import org.example.order.dtos.OrderDetailsDto;
import org.example.order.dtos.OrderResponseDetailsDto;
import org.example.order.repositories.OrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderServices {

    @Autowired
    OrderRepositories orderRepositories;

    public OrderResponseDetailsDto checkOut(OrderDetailsDto detailsDto)
    {
        OrderResponseDetailsDto orderResponseDetailsDto = orderRepositories.checkOut(detailsDto);
        return orderResponseDetailsDto;
    }

}
