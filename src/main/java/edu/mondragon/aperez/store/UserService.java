package edu.mondragon.aperez.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("User already exists: " + user.getEmail());
        }
        userRepository.save(user);
        notificationService.sendNotification(user, "Welcome to our store!");
        
    }

    
}
