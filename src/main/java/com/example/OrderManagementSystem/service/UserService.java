package com.example.OrderManagementSystem.service;

import com.example.OrderManagementSystem.entity.Users;
import com.example.OrderManagementSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(Users users){
        userRepository.save(users);
    }

    public List<Users> getAllUsers(){
       return userRepository.findAll();
    }

    public Users getUserById(Long id){

        return userRepository.findById(id).get();
    }
}

