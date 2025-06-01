package org.example.payment.dtos;

import org.example.payment.models.PaymentDetailsModel;

public class PaymentResponseDetailsDto {
    private String status;
    private PaymentDetailsModel paymentDetailsModel;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaymentDetailsModel getPaymentDetailsModel() {
        return paymentDetailsModel;
    }

    public void setPaymentDetailsModel(PaymentDetailsModel paymentDetailsModel) {
        this.paymentDetailsModel = paymentDetailsModel;
    }
}
