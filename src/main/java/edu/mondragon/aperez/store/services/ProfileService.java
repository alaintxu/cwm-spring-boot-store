package edu.mondragon.aperez.store.services;

import org.springframework.stereotype.Service;
import edu.mondragon.aperez.store.repositories.ProfileRepository;
import edu.mondragon.aperez.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileService {
    ProfileRepository profileRepository;
    UserRepository userRepository;

    @Transactional
    public void printLoyalProfiles() {
        // var profiles = profileRepository.findLoyalProfiles(7);
        // profiles.forEach(profile -> {
        //     System.out.println(profile.getId() + ": "+ profile.getUser().getEmail());
        // });
        var users = userRepository.findLoyalUserSummaries(7);
        users.forEach(user -> {
            System.out.println(user.getId() + ": " + user.getEmail());
        });
    }
    
}
