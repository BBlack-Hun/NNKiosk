package com.example.nnk.repository;


import com.example.nnk.domain.Food;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FoodRepository {
    Food save(Food food);
    Optional<Food> findById(String id);
    List<Food> findByName(String name);
    List<Food> findAll();
    List<Food> findByType(String foodType);
    Food update(String id, Food food);
    Food delete(String id);
}
