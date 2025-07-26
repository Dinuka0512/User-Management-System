package com.example.testspringbootproject.service.impl;

import com.example.testspringbootproject.dto.UserDto;
import com.example.testspringbootproject.entity.User;
import com.example.testspringbootproject.repositry.UserRepo;
import com.example.testspringbootproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceIImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public ArrayList<UserDto> getAllUsers() {
        List<User> all = userRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<UserDto>>() {}.getType());
    }

    @Override
    public void saveNewUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void deleteUser(UserDto userDto) {
        userRepo.delete(modelMapper.map(userDto, User.class));
    }

    @Override
    public ArrayList<UserDto> searchUsers(String userName) {
        List<User> userDtos = userRepo.searchUserByNameContainsIgnoreCase(userName);
        return modelMapper.map(userDtos, new  TypeToken<ArrayList<UserDto>>() {}.getType());
    }
}
