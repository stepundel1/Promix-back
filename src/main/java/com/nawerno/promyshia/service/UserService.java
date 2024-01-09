package com.nawerno.promyshia.service;

import com.nawerno.promyshia.entity.User;

public interface UserService {
    User getById(int id);
    void create(User user, String passwordHash);

    Boolean existsByEmail(String email);
}
