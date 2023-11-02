package com.web.Service;

import com.web.model.User;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update (int id, User updatedUser);

    void delete(int id);

    void addDefaultUsers();
}
