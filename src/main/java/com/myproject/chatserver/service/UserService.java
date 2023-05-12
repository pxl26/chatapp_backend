package com.myproject.chatserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.chatserver.Model.SignupRequest;
import com.myproject.chatserver.entity.UserEntity;
import com.myproject.chatserver.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public List<UserEntity> getUserList() {
        return repo.getAll();
    }

    public void saveUser(SignupRequest rq) {
        String defaultRole = "USER";
        UserEntity user = new UserEntity(rq.getUsername(), rq.getPassword(), defaultRole, rq.getFullName(),
                rq.getEmail());
        repo.insertUser(user);
    }
}
