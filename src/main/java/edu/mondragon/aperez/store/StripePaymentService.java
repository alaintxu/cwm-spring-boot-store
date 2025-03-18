package edu.mondragon.aperez.store;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// @Service("stripe")
// @Primary
public class StripePaymentService implements PaymentService{
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.currencies}")
    private List<String> supportedCurrencies;

    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Override
    public void processPayment(double amount) {
        if(!enabled){
            System.out.println("STRIPE is not enabled");
            return;
        }
        System.out.println("STRIPE (" + apiUrl + ")");
        System.out.println("Timeout: " + timeout);
        System.out.println("Supported currencies: " + supportedCurrencies);
        System.out.println("Amount: " + amount);
    }
}