package com.example.floralhub;




import com.example.floralhub.entity.plant;
import com.example.floralhub.repository.plantrepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class plantrepositorytest {

    @Autowired
    private plantrepository plantrepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveItem(){
        plant plant= new plant();

        plant.setDescription("Testing description");
        plant.setPlantname("Testing item name");
        plant.setPrice("1200");
        plant.setPot("10");
        plant.setHeight("10");
        plant.setCategory("indoor");
        plant.setSection("newarrival");
        plant.setTempertaure("10");




        plant=plantrepository.save(plant);

        Assertions.assertThat(plant.getId()).isGreaterThan(0);


    }


    @Test
    @Order(2)
    public void findById(){
        plant item= plantrepository.findById(1).get();
        Assertions.assertThat(item.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void findAllData(){
        List<plant> itemList=plantrepository.findAll();
        Assertions.assertThat(itemList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateItem(){
        plant item= plantrepository.findById(1).get();
        item.setPlantname("updated testing item name");
        item=plantrepository.save(item);

        Assertions.assertThat(item.getPlantname()).isEqualTo("updated testing item name");
    }

    @Test
    @Order(5)
    public void DeleteByID(){
        plantrepository.deleteById(1);

        plant item1=null;

        Optional<plant> item=plantrepository.findById(1);

        if(item.isPresent()){
            item1=item.get();
        }

        Assertions.assertThat(item1).isNull();

    }
}