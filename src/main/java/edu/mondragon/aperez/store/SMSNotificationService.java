package edu.mondragon.aperez.store;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService{

    @Override
    public void sendNotification(User user, String message) {
        System.out.println("SMS to: " + user.getPhone());
        System.out.println("Message: " + message);
    }
    
}
