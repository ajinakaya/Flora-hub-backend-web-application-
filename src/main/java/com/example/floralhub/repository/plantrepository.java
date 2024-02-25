package com.example.floralhub.repository;



import com.example.floralhub.entity.plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface plantrepository extends JpaRepository <plant, Integer> {

}