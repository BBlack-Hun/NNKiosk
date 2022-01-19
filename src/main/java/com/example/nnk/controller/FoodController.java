package com.example.nnk.controller;

import com.example.nnk.domain.Food;
import com.example.nnk.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/food")
@RestController
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public String create(Food food) {
        return foodService.add(food);
    }

    @GetMapping
    public List<Food> getAll() {
        return foodService.findAllFoods();
    }

    @PutMapping
    public List<Food> updateAll(List<Food> foods) {
        return foodService.updateAllFoods(foods);
    }

    @DeleteMapping
    public boolean deleteAll() {
        return foodService.deleteAllFoods();
    }

    @GetMapping("/{id}")
    public Optional<Food> getFoodById(@PathVariable String id) {
        return foodService.findFoodById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id,
                         Food food) {
        return foodService.update(id, food);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return foodService.remove(id);
    }

    @GetMapping("/{name}")
    public List<Food> getFoodsByName(@PathVariable String name) {
        return foodService.findFoodsByName(name);
    }

    @GetMapping("/{foodType}")
    public List<Food> getFoodByType(@PathVariable String foodType) {
        return foodService.findFoodsByType(foodType);
    }
}
