package org.ecommerce.spring_test.Controller;

import org.ecommerce.spring_test.DTO.UserRequest;
import org.ecommerce.spring_test.DTO.UserResponse;
import org.ecommerce.spring_test.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //create new user
    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse response = userService.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //update user by user id
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer userId, @RequestBody UserRequest userRequest){
        UserResponse response = userService.updateUser(userId, userRequest);
        return ResponseEntity.ok(response);
    }

    //delete user by user id
    @DeleteMapping("deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        String response = userService.deleteUser(userId);
        return ResponseEntity.ok(response);
    }

}
