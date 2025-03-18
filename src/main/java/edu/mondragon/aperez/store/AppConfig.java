package edu.mondragon.aperez.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${payment.gateway:paypal}")
    private String paymentGatewayString;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PayPalPaymentService();
    }
    
    @Bean
    public OrderService orderService() {
        if(paymentGatewayString.equals("stripe")) {
            return new OrderService(stripe());
        }
        return new OrderService(paypal());
    }

}
