package org.example.order.repositories;


import org.example.order.dtos.OrderDetailsDto;
import org.example.order.dtos.OrderResponseDetailsDto;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositories {

    public OrderResponseDetailsDto checkOut(OrderDetailsDto detailsDto)
    {
        OrderResponseDetailsDto orderResponseDetailsDto = new OrderResponseDetailsDto();
        orderResponseDetailsDto.setProductName("Ball");
        orderResponseDetailsDto.setStatus("Success");
        return orderResponseDetailsDto;
    }
}
