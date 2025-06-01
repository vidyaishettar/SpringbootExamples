package org.example.payment.services;

import org.example.payment.dtos.PaymentDetailsDto;
import org.example.payment.dtos.PaymentResponseDetailsDto;
import org.example.payment.models.PaymentDetailsModel;
import org.example.payment.repositories.PaymentRepositories;
import org.example.payment.repositories.intf.PaymentRepositoryJPAIntf;
import org.example.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class PaymentServices {

    @Autowired
    PaymentRepositories paymentRepositories;

    @Autowired
    PaymentRepositoryJPAIntf paymentRepositoryJPA;

    public PaymentResponseDetailsDto create(PaymentDetailsDto paymentDetails)
    {
        PaymentResponseDetailsDto paymentResponseDetailsDto = paymentRepositories.create(paymentDetails);
        return paymentResponseDetailsDto;
    }

    public PaymentResponseDetailsDto createwithJPA(PaymentDetailsDto paymentDetails)
    {
        PaymentDetailsModel paymentDetailsModel = new PaymentDetailsModel();
        User user = new User();
        user.setId(paymentDetails.getUserDetailsId());
        paymentDetailsModel.setUser(user);

        PaymentDetailsModel savedPayment = paymentRepositoryJPA.save(paymentDetailsModel);
        PaymentResponseDetailsDto paymentResponseDetailsDto = new PaymentResponseDetailsDto();
        paymentResponseDetailsDto.setStatus("success");
        return paymentResponseDetailsDto;
    }

    public PaymentResponseDetailsDto findPaymentById(Integer paymentId)
    {
        Optional<PaymentDetailsModel> payment = paymentRepositoryJPA.findById(paymentId);
        PaymentResponseDetailsDto paymentResponseDetailsDto = new PaymentResponseDetailsDto();
        paymentResponseDetailsDto.setPaymentDetailsModel(payment.get());
        paymentResponseDetailsDto.setStatus("success");
        return paymentResponseDetailsDto;

    }
}
