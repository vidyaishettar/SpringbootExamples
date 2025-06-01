package org.example.payment.repositories.intf;

import org.example.payment.models.PaymentDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoryJPAIntf extends JpaRepository<PaymentDetailsModel,Integer> {

}
