package com.nawerno.promyshia.repository.write;

import com.nawerno.promyshia.entity.User;

public interface UserWriteRepository {
    int create(User u, String passwordHash);

}
