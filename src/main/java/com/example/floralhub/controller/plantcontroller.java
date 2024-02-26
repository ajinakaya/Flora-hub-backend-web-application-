package com.example.floralhub.controller;

import com.example.floralhub.DTO.plantdto;
import com.example.floralhub.entity.plant;
import com.example.floralhub.Service.plantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/plant")
@RequiredArgsConstructor
public class plantcontroller {

    private final plantService plantService;

    @GetMapping("/data")
    public  String getData(){
        return "data retrieved";
    }

    @PostMapping("/plant")
    public String createData(@RequestBody plantdto plantdto){
        plantService.save(plantdto);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<plant> getAllData() {
        return plantService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<plant> getById(@PathVariable("id") Integer id) {
        return plantService.getById(id);
    }

    @PutMapping("/update/{id}")
    public String updateData(@PathVariable("id") Integer id, @RequestBody plantdto plantdto) {
        Optional<plant> existingPlant = plantService.getById(id);

        if (existingPlant.isPresent()) {
            plantService.update(id, plantdto);
            return "updated data";
        } else {
            return "Plant not found with id: " + id;
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public  void deleteById(@PathVariable("id") Integer id) {
        plantService.deleteById(id);
    }


    @GetMapping("/section/{section}")
    public ResponseEntity<List<plant>> getPlantsBySection(@PathVariable String section) {
        List<plant> plants = plantService.getPlantsBySection(section);
        if (plants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<plant>> getPlantsByCategory(@PathVariable String category) {
        List<plant> plants = plantService.getPlantsByCategory(category);
        if (plants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<plant>> searchPlants(@RequestParam String plantname, @RequestParam String category) {
        List<plant> plants = plantService.searchPlants(plantname, category);
        if (plants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
    }
}