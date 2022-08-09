package com.example.accesssystem.service;

import com.example.accesssystem.entity.UserEntity;
import com.example.accesssystem.error.UserNotFoundException;
import com.example.accesssystem.model.User;
import com.example.accesssystem.other.QRCodeGenerator;
import com.example.accesssystem.repository.UserRepo;
import com.google.zxing.WriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) {
        String username = user.getFirst_name().toLowerCase() + "_" + user.getLast_name().toLowerCase();
        user.setUsername(username);
        user.setQr_code(username);
        try {
            new QRCodeGenerator().generatorQrCodeImage(username);
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }
        return userRepo.save(user);
    }

    public UserEntity getOneUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден!");
        }
        return user;
    }

    public User getInfoOneUser(Long id) {
        UserEntity entity = userRepo.findById(id).get();
        return User.toModel(entity);
    }

}
