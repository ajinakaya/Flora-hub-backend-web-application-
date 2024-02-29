package com.example.floralhub.Service.impl;


import com.example.floralhub.DTO.orderDTO;
import com.example.floralhub.entity.order;
import com.example.floralhub.repository.orderRepository;
import com.example.floralhub.Service.orderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class orderServiceimpl implements orderService {

    private final orderRepository orderRepository;

    @Override
    public String save(orderDTO orderDTO) {
        order order = new order();

        if (orderDTO.getId() != null) {
            order = orderRepository.findById(orderDTO.getId()).orElseThrow(() -> new NullPointerException("Data not found"));
        }

        order.setEmail(orderDTO.getEmail());
        order.setUsername(orderDTO.getUsername());
        order.setAddress(orderDTO.getAddress());
        order.setPlants(orderDTO.getPlants());
        order.setPhoneNumber(orderDTO.getPhoneNumber());
        order.setTotalAmount(orderDTO.getTotalAmount());


        orderRepository.save(order);

        return "created";
    }

    @Override
    public List<order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<order> getById(Integer id) {
        return orderRepository.findById(id);
    }
    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }




}