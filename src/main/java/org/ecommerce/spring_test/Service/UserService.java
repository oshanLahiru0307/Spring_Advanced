package org.ecommerce.spring_test.Service;


import org.ecommerce.spring_test.DTO.UserResponse;
import org.ecommerce.spring_test.Model.User;
import org.ecommerce.spring_test.Repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ModelMapper modelMapper;

    //get all users
    public List<UserResponse> getAllUsers() {
        try{
            List<User> users = userRepository.findAll();
            return modelMapper.map(users, new TypeToken<List<UserResponse>>() {}.getType());
        }catch (Exception e){
            throw new RuntimeException("Error retrieving users: " + e.getMessage());
        }
    }
}
