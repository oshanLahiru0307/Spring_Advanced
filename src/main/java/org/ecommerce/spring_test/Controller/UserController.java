package org.ecommerce.spring_test.Controller;

import org.ecommerce.spring_test.DTO.UserResponse;
import org.ecommerce.spring_test.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    //get all users
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }

    //get user by user id
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer userId){
        UserResponse response = userService.getUserByUserId(userId);
        return ResponseEntity.ok(response);
    }



}
