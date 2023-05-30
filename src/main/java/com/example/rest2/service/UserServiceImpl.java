package com.example.rest2.service;

import com.example.rest2.dto.CityRequestDTO;
import com.example.rest2.dto.UserRequestDTO;
import com.example.rest2.dto.UserResponseDTO;
import com.example.rest2.entity.User;
import com.example.rest2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl {

    private UserRepository userRepository;

    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> list = new ArrayList<>();
        userRepository.findAll().forEach(
                u -> {
                    UserResponseDTO userResponseDTO = new UserResponseDTO(
                            u.getId(), u.getUsername(), u.getPassword(), u.getEmail()
                    );
                    list.add(userResponseDTO);
                }
        );
        return list;
    }

    public UserResponseDTO getUser(Long id) {
        User user = userRepository.findById(id).get();
        return new UserResponseDTO(
                user.getId(), user.getUsername(), user.getPassword(), user.getEmail()
        );
    }

    public UserResponseDTO addUser(UserRequestDTO userDTO) {
        User user = new User(
                null,
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmail()
        );
        userRepository.save(user);
        return new UserResponseDTO();
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userDTO) {
        User user = userRepository.findById(id).get();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());

        userRepository.save(user);

        return new UserResponseDTO(
                user.getId(), user.getUsername(), user.getPassword(), user.getEmail()
        );
    }


    public UserResponseDTO deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return new UserResponseDTO(
                user.getId(), user.getUsername(), user.getPassword(), user.getEmail()
        );
    }
}
