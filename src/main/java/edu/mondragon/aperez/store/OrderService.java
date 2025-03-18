package edu.mondragon.aperez.store;

// import org.springframework.stereotype.Service;

// @Service
public class OrderService {

    private PaymentService paymentService;

    // If there are multiple constructors, we need the @Autowired annotation
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    public void placeOrder() {
        paymentService.processPayment(100);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
