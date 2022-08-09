package com.example.accesssystem.repository;


import com.example.accesssystem.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
}
