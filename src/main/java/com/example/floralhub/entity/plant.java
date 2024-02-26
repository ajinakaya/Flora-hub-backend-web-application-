package com.example.floralhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plant", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_plant_name", columnNames = "plantName")
})


public class plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plantname", nullable = false)
    private String plantname;

    @Column(name = "imageurl")
    private String imageurl;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "height")
    private String height;

    @Column(name = "category")
    private String category;

    @Column(name = "pot")
    private String pot;

    @Column(name = "tempertaure")
    private String tempertaure;

    @Column(name = "section")
    private String section;


}