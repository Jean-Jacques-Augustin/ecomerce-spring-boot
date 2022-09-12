package com.me.forum.controller;

import com.me.forum.model.User;
import com.me.forum.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Enregistement des utilisateurs
    @PostMapping
    public void addUser (@RequestBody User user) {
        userService.addUser(user);
    }

    //Liste des utilisateurs
    @GetMapping
    public List<User> getAllUser () {
        return userService.getAllUser();
    }
    // Supprimer un utilisateur
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    // Modifier un utilisateur
    @PutMapping(path = "{userID}")
    public void updateUser(@PathVariable("userID") Long userId,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email,
                           @RequestParam String name,
                           @RequestParam String city,
                           @RequestParam String type) {
        userService.updateUser(userId, username, password, email, name, city, type);
    }
}
