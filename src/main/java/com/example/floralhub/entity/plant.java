package com.example.floralhub.entity;

import jakarta.persistence.*;
import lombok.*;


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

    @Column(name = "description")
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




    public void setId(Integer id) {
        this.id = id;
    }



    public void setPlantname(String plantname) {
        this.plantname = plantname;
    }



    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


    public void setPrice(String price) {
        this.price = String.valueOf(price);
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public void setHeight(String height) {
        this.height = height;
    }


    public void setCategory(String category) {
        this.category = category;
    }



    public void setPot(String pot) {
        this.pot = pot;
    }


    public void setSection(String section) {
        this.section = section;
    }

    public void settempertaure(String tempertaure) {
        this.tempertaure = tempertaure;
    }
}
