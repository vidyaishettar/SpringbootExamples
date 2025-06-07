package office.support.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SupportConfiguration {
    @Bean
    public CustomerSupport createCustomerSuppport()
    {
        return new CustomerSupport();
    }
}
