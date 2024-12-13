package com.javarush.khmelov.service;

import com.javarush.khmelov.repository.InMemoryUserRepository;
import com.javarush.khmelov.entity.User;

import java.util.Collection;
import java.util.Optional;

public class UserService {

    private final InMemoryUserRepository userRepository;

    public UserService(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> get(long id) {
        return userRepository.get(id);
    }
}
