package com.example.nnk.repository;

import com.example.nnk.domain.Food;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MongoFoodRepository implements FoodRepository {
    @Override
    public Food save(Food food) {
        return null;
    }

    @Override
    public Optional<Food> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Food> findByName(String name) {
        return null;
    }

    @Override
    public List<Food> findAll() {
        return null;
    }

    @Override
    public List<Food> findByType(String foodType) {
        return null;
    }

    @Override
    public Food update(String id, Food food) {
        return null;
    }

    @Override
    public Food delete(String id) {
        return null;
    }
}
