package com.example.floralhub.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class plantdto {

    private Integer id;

    @NotNull
    private String plantname;

    @NotNull
    private String imageurl;

    @NotNull
    private String price;

    @NotNull
    private String description;

    @NotNull
    private String height;

    @NotNull
    private String category;

    @NotNull
    private String pot;

    @NotNull
    private String tempertaure;

    @NotNull
    private String section;

}