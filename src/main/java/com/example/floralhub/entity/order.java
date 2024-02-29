package com.example.floralhub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="PAYMENT")


public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "address", nullable = false)
    private String address;

    @ElementCollection
    @CollectionTable(name = "PLANTS", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "plant")
    private List<String> plants;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "totalAmount")
    private String totalAmount;


}


