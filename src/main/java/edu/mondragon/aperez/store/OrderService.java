package edu.mondragon.aperez.store;

public class OrderService {
    private PaymentService paymentService;

    // public OrderService(PaymentService paymentService) {
    //     this.setPaymentService(paymentService);
    // }

    public void placeOrder() {
        paymentService.processPayment(100);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
