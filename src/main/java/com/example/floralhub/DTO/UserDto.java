package com.example.floralhub.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private Integer id;

    @NotNull
    private String fullName;

    @NotNull
    private String email;

    @NotNull
    private String Username;

    @NotNull
    private String password;
}