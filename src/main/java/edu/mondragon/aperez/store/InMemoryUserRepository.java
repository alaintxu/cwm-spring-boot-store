package edu.mondragon.aperez.store;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
        System.out.println("User saved: " + user.getEmail() + " " + user.getPhone());
    }

    @Override
    public User findByEmail(String email) {
        return users.getOrDefault(email, null);
    }

}
