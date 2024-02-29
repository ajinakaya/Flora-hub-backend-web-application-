package com.example.floralhub.controller;

import com.example.floralhub.DTO.orderDTO;
import com.example.floralhub.entity.order;
import com.example.floralhub.Service.orderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class orderController {

    private final orderService orderService;

    @GetMapping("/data")
    public String getData() {
        return "data retrieved";
    }

    @PostMapping("/order")
    public String createData(@RequestBody orderDTO orderDTO) {
        orderService.save(orderDTO);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<order> getAllData() {
        return orderService.getAll();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        try {
            Integer orderId = Integer.parseInt(id);
            Optional<order> result = orderService.getById(orderId);

            if (result.isPresent()) {
                return ResponseEntity.ok(result.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid ID format");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        orderService.deleteById(id);
    }






}