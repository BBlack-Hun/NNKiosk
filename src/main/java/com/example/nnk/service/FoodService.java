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

    public String add(Food food) {
        return foodRepository.save(food).get_id();
    }

    public List<Food> findAllFoods() {
        return foodRepository.findAll();
    }

    public Optional<Food> findFoodById(String id) {
        return foodRepository.findById(id);
    }

    public List<Food> findFoodByName(String name) {
        return foodRepository.findByName(name);
    }

    public List<Food> findFoodByType(String foodType) {
        return foodRepository.findByType(foodType);
    }

    public String update(String id, Food food) {
        return foodRepository.update(id, food).get_id();
    }

    public String remove(String id) {
        return foodRepository.delete(id).get_id();
    }
}
