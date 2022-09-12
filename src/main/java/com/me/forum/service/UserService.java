package com.me.forum.service;


import com.me.forum.model.User;
import com.me.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser () {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        boolean exists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (exists) {
            throw new IllegalStateException("Adresse email deja enregistré");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId  ) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("Identifiant non trouvé");
        }
        userRepository.deleteById(userId);
    }


    @Transactional
    public void updateUser(Long userId, String username, String password, String email, String name, String city, String type) {
        boolean exists = userRepository.existsById(userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("Identifiant non trouvé"));
        if (!exists) {
            throw new IllegalStateException("Identifiant non trouvé");
        }

        if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
    }

}