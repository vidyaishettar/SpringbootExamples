package org.example.payment.controllers;

import jakarta.websocket.server.PathParam;
import org.example.payment.dtos.PaymentDetailsDto;
import org.example.payment.dtos.PaymentResponseDetailsDto;
import org.example.payment.models.PaymentDetailsModel;
import org.example.payment.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/payment")

public class PaymentController {

    @Autowired
    PaymentServices paymentServices;
    @PostMapping("/create")
    public @ResponseBody PaymentResponseDetailsDto create (@RequestBody PaymentDetailsDto paymentdetails)
    {
        PaymentResponseDetailsDto paymentResponseDetailsDto = paymentServices.create(paymentdetails);
        return  paymentResponseDetailsDto;
    }


    @PostMapping("/createwithJPA")
    public @ResponseBody PaymentResponseDetailsDto createwithJPA(@RequestBody PaymentDetailsDto paymentdetails)
    {
        PaymentResponseDetailsDto paymentResponseDetailsDto = paymentServices.createwithJPA(paymentdetails);
        return  paymentResponseDetailsDto;
    }

    @GetMapping("/{id}")
    public @ResponseBody PaymentResponseDetailsDto findById(@PathVariable("id") Integer id)
    {

        PaymentResponseDetailsDto paymentResponseDetailsDto = paymentServices.findPaymentById(id);
        return  paymentResponseDetailsDto;
    }

}
