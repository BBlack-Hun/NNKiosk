package com.example.nnk.service;

import com.example.nnk.domain.Food;
import com.example.nnk.repository.FoodRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public UUID add(Food food) {
        return foodRepository.save(food).getId();
    }

    public List<Food> findAllFoods() {
        return foodRepository.findAll();
    }

    public Optional<Food> findFoodById(UUID uuid) {
        return foodRepository.findById(uuid);
    }

    public List<Food> findFoodByName(String name) {
        return foodRepository.findByName(name);
    }

    public List<Food> findFoodByType(String foodType) {
        return foodRepository.findByType(foodType);
    }

    public UUID update(UUID id, Food food) {
        return foodRepository.update(id, food).getId();
    }

    public UUID remove(UUID id) {
        return foodRepository.delete(id).getId();
    }
}
