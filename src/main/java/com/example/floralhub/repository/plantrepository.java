package com.example.floralhub.repository;

import com.example.floralhub.entity.plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface plantrepository extends JpaRepository <plant, Integer> {

    List<plant> findBySection(String section);
    List<plant> findByCategory(String category);
    List<plant> findByPlantnameAndCategory(String plantname, String category);
}