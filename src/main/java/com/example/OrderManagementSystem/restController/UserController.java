package com.example.OrderManagementSystem.restController;

import com.example.OrderManagementSystem.entity.Address;
import com.example.OrderManagementSystem.entity.Orders;
import com.example.OrderManagementSystem.entity.Users;
import com.example.OrderManagementSystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<String> addNewUser(@RequestBody Users users){
        userService.addNewUser(users);
        return new ResponseEntity<>("Data added !!", HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsersData(){
        return new ResponseEntity<>( userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/users/{id}/orders")
    public ResponseEntity<List<Orders>> getOrderByUser(@PathVariable Long id){
        return new ResponseEntity<>( userService.getUserById(id).getOrders(),HttpStatus.OK);
    }

    @GetMapping("/users/{id}/address")
    public ResponseEntity<Address> getAddressOfUser(@PathVariable Long id){
        return new ResponseEntity<>( userService.getUserById(id).getAddress(),HttpStatus.OK);
    }
}
