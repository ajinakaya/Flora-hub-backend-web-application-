package com.example.floralhub.Service;
import com.example.floralhub.DTO.orderDTO;
import com.example.floralhub.entity.order;

import java.util.List;
import java.util.Optional;

public interface orderService {
    String save(orderDTO orderDTO);

    List<order> getAll();
    Optional<order> getById(Integer id);
    void deleteById(Integer id);


}