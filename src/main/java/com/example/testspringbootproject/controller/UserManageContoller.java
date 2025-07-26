package com.example.testspringbootproject.controller;

import com.example.testspringbootproject.dto.UserDto;
import com.example.testspringbootproject.service.UserService;
import com.example.testspringbootproject.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("user/v1/api")
@RequiredArgsConstructor
public class UserManageContoller {
    private final UserService userService;

    @GetMapping("getAll")
    public ResponseEntity<APIResponse> getAllUsers() {
        ArrayList<UserDto> userDtos = userService.getAllUsers();
        return new ResponseEntity<>(new APIResponse("200", "OK", userDtos), HttpStatus.OK);
    }

    @PostMapping("saveUser")
    public ResponseEntity<APIResponse> saveNewUser(@RequestBody UserDto userDto) {
        userService.saveNewUser(userDto);
        return new ResponseEntity<>(new APIResponse("200", "User saved!", null), HttpStatus.OK);
    }

    @PatchMapping("updateUser")
    public ResponseEntity<APIResponse> updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        return new ResponseEntity<>(new APIResponse("200", "User Updated", null), HttpStatus.OK);
    }

    @DeleteMapping("deleteUser")
    public ResponseEntity<APIResponse> deleteUser(@RequestBody UserDto userDto) {
        userService.deleteUser(userDto);
        return new ResponseEntity<>(new APIResponse("200", "User Deleted", null), HttpStatus.OK);
    }

    @GetMapping("searchUsers/{name}")
    public ResponseEntity<APIResponse> searchUsers(@PathVariable("name") String userName) {
        ArrayList<UserDto> users = userService.searchUsers(userName);
        return new ResponseEntity<>(new APIResponse("200", "OK", users), HttpStatus.OK);
    }
}
