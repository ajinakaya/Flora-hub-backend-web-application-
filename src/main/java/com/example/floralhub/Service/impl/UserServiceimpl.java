package com.example.floralhub.Service.impl;

import com.example.floralhub.DTO.UserDto;
import com.example.floralhub.Service.UserService;
import com.example.floralhub.config.PasswordEncoderUtil;
import com.example.floralhub.entity.User;
import com.example.floralhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public String save(UserDto userDto) {

        User user = new User();

        if(userDto.getId()!=null) {
            user=userRepository.findById((userDto.getId())).orElseThrow(() ->new NullPointerException("data not found"));
        }

        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userDto.getPassword()));

        userRepository.save(user);


        return "created";
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


}
