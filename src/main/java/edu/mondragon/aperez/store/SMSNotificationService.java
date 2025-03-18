package edu.mondragon.aperez.store;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService{

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS");
        System.out.println("Message: " + message);
    }
    
}
