package com.web.Service;

import com.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp {
    private final UserRepository userRepository;

    private static int USERS_COUNT;
    List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USERS_COUNT, "Iron", "Man"));
        users.add(new User(++USERS_COUNT, "Captain", "America"));
        users.add(new User(++USERS_COUNT, "Doctor", "Strange"));
        users.add(new User(++USERS_COUNT, "Scarlet", "Witch"));
        users.add(new User(++USERS_COUNT, "Nick", "Fury"));
    }

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update (int id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void addDefaultUsers() {
        userRepository.saveAll(users);
    }
}
