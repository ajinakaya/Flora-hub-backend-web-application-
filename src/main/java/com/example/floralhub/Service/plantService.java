package com.example.floralhub.Service;
import com.example.floralhub.DTO.plantdto;
import com.example.floralhub.entity.plant;

import java.util.List;
import java.util.Optional;

public interface plantService {
    String save(plantdto plantdto);

    List<plant> getAll();
    Optional<plant> getById(Integer id);
    void deleteById(Integer id);
    String update(Integer id, plantdto plantdto);

    List<plant> getPlantsBySection(String section);
    List<plant> getPlantsByCategory(String category);

}