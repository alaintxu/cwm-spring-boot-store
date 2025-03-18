package edu.mondragon.aperez.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService{

    @Override
    public void sendNotification(String message) {
        System.out.println("EMAIL");
        System.out.println("Message: " + message);
    }
    
}
