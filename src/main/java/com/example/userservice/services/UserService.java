package com.example.userservice.services;


import com.example.userservice.models.User;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    @Autowired
    private UserRepository userRepository;

    // 🔎 Récupérer un utilisateur par email
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // 🔄 Créer un utilisateur (appelé par le CustomOAuth2UserService)
    public User save(User user) {
        return userRepository.save(user);
    }

    // 📋 Lister tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ❌ Supprimer un utilisateur (si besoin)
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}