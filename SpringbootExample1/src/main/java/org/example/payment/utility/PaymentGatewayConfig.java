package org.example.payment.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentGatewayConfig {

    @Bean
    public RazorPay razorPayClient()
    {
        System.out.println("creating razorPay object");
        return new RazorPay("secreteKey");
    }
}
