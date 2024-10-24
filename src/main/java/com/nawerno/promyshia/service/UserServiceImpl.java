package com.nawerno.promyshia.service;

import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.repository.read.UserReadRepository;
import com.nawerno.promyshia.repository.write.UserWriteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base32;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserReadRepository userReadRepository;
    private final UserWriteRepository userWriteRepository;

    @Override
    public User getById(int id){
        createToken(userReadRepository.getById(id));
        return userReadRepository.getById(id);

    }

    @Override
    public void create(User user, String passwordHash){
        var newId = userWriteRepository.create(user, passwordHash);
        user.setId(newId);
        userWriteRepository.updateToken(user.getId(), createToken(user));
    }

    @Override
    public Boolean existsByEmail(String email){
        return userReadRepository.existsByEmail(email);
    }

    private String createToken(User u){
        Base32 base32 = new Base32();
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        var rawToken = (u.getId()) + Integer.toString(randomNumber);

        var token = base32.encodeAsString(rawToken.getBytes());
        return token.substring(0, token.indexOf("="));
    }


}
