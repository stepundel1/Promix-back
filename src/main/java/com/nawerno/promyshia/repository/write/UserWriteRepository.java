package com.nawerno.promyshia.repository.write;

import com.nawerno.promyshia.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserWriteRepository {
    int create(User u, String passwordHash);

    void updateToken(@Param("id") int id, @Param("token") String token);

}
