package com.example.floralhub.Service;



import com.example.floralhub.DTO.UserDto;
import com.example.floralhub.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String save(UserDto userDto);

    List<User> getAll();

    Optional<User> getById(Integer id);

    void deleteById(Integer id);
}