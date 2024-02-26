package com.example.floralhub.Service.impl;


import com.example.floralhub.DTO.plantdto;
import com.example.floralhub.entity.plant;
import com.example.floralhub.repository.plantrepository;
import com.example.floralhub.Service.plantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class plantimpl implements plantService {

    private final plantrepository plantrepository;

    @Override
    public String save(plantdto plantdto) {
        plant plant = new plant();

        if (plantdto.getId() != null) {
            plant = plantrepository.findById(plantdto.getId()).orElseThrow(() -> new NullPointerException("Data not found"));
        }

        plant.setPlantname(plantdto.getPlantname());
        plant.setPrice(plantdto.getPrice());
        plant.setDescription(plantdto.getDescription());
        plant.setCategory(plantdto.getCategory());
        plant.setSection(plantdto.getSection());
        plant.setTempertaure(plantdto.getTempertaure());
        plant.setHeight(plantdto.getHeight());
        plant.setPot(plantdto.getPot());
        plant.setImageurl(plantdto.getImageurl());

        plantrepository.save(plant);

        return "created";
    }

    @Override
    public List<plant> getAll() {
        return plantrepository.findAll();
    }

    @Override
    public Optional<plant> getById(Integer id) {
        return plantrepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        plantrepository.deleteById(id);
    }

    public String update(Integer id, plantdto plantdto) {
        Optional<plant> optionalPlant = plantrepository.findById(id);

        if (optionalPlant.isPresent()) {
            plant existingPlant = optionalPlant.get();

            existingPlant.setPlantname(plantdto.getPlantname());
            existingPlant.setPrice(plantdto.getPrice());
            existingPlant.setDescription(plantdto.getDescription());
            existingPlant.setCategory(plantdto.getCategory());
            existingPlant.setSection(plantdto.getSection());
            existingPlant.setTempertaure(plantdto.getTempertaure());
            existingPlant.setHeight(plantdto.getHeight());
            existingPlant.setPot(plantdto.getPot());
            existingPlant.setImageurl(plantdto.getImageurl());

            plantrepository.save(existingPlant);

            return "updated";
        } else {
            return "Plant not found with id: " + id;
        }

    }
    public List<plant> getPlantsBySection(String section) {
        return plantrepository.findBySection(section);
    }

    public List<plant> getPlantsByCategory(String category) {
        return plantrepository.findByCategory(category);
    }
    public List<plant> searchPlants(String plantname, String category) {
        return plantrepository.findByPlantnameAndCategory(plantname, category);
    }
}