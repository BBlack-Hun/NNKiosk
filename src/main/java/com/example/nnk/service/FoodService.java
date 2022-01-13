package com.example.nnk.service;

import com.example.nnk.domain.Food;
import com.example.nnk.repository.MongoFoodRepository;

import java.util.List;
import java.util.Optional;

public class FoodService {
    private final MongoFoodRepository repository;

    public FoodService(MongoFoodRepository repository) {
        this.repository = repository;
    }

    public String add(Food food) {
        return repository.save(food).get_id();
    }

    public List<Food> findAllFoods() {
        return repository.findAll();
    }

    public List<Food> updateAllFoods(List<Food> foods) {
        return repository.saveAll(foods);
    }

    public Boolean deleteAllFoods() {
        try {
            repository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Food> findFoodById(String id) {
        return repository.findById(id);
    }

    public String update(String id, Food food) {
        food.set_id(id);
        return repository.save(food).get_id();
    }

    public String remove(String id) {
        repository.deleteById(id);
        return id;
    }

    public List<Food> findFoodsByName(String name) {
        return repository.findAllFoodsByName(name);
    }

    public List<Food> findFoodByType(String foodType) {
        return null;
    }
}
