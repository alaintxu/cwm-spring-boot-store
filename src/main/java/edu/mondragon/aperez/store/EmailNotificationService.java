package edu.mondragon.aperez.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService{

    @Value("${mail.host:localhost}")
    private String host;

    @Value("${mail.port:25}")
    private String port;

    @Override
    public void sendNotification(User user, String message) {
        System.out.println("EMAIL to: " + user.getEmail());
        System.out.println(host + ":" + port);
        System.out.println("Message: " + message);
    }
    
}
