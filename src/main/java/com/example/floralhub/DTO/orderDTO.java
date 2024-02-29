package com.example.floralhub.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class orderDTO {

    private Integer id;

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String address;

    @NotNull
    private String phoneNumber;

    @NotNull
    private List<String> plants;

    @NotNull
    private String totalAmount;




}