package com.nawerno.promyshia.repository.read;

import com.nawerno.promyshia.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReadRepository {
    @Select("select * from users where id=#{id}")
    User getById (@Param("id") int id);
    Optional<User> getByEmail (@Param("email") String email);

    @Select("select exists(select 1 from users where email=#{email})")
    Boolean existsByEmail(@Param("email") String email);

}

