package com.example.rest2.controller;

import com.example.rest2.dto.CityRequestDTO;
import com.example.rest2.dto.UserRequestDTO;
import com.example.rest2.dto.UserResponseDTO;
import com.example.rest2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserResponseDTO> userList() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PutMapping(value = "/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public UserResponseDTO deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }



}
