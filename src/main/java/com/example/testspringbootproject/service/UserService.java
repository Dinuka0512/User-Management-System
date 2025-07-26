package com.example.testspringbootproject.service;

import com.example.testspringbootproject.dto.UserDto;

import java.util.ArrayList;

public interface UserService {
    ArrayList<UserDto> getAllUsers();

    void saveNewUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(UserDto userDto);

    ArrayList<UserDto> searchUsers(String userName);
}
