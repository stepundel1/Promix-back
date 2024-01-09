package com.nawerno.promyshia.service;

import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.repository.read.UserReadRepository;
import com.nawerno.promyshia.repository.write.UserWriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserReadRepository userReadRepository;
    private final UserWriteRepository userWriteRepository;

    @Override
    public User getById(int id){
        return userReadRepository.getById(id);
    }

    @Override
    public void create(User user, String passwordHash){
        var newId = userWriteRepository.create(user, passwordHash);
        user.setId(newId);
    }

    @Override
    public Boolean existsByEmail(String email){
        return userReadRepository.existsByEmail(email);
    }

}
