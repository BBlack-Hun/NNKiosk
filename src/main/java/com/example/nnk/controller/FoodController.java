package com.example.nnk.controller;

import com.example.nnk.domain.Food;
import com.example.nnk.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/food")
@RestController
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/new")
    public UUID create(Food food) {
        return foodService.add(food);
    }

    @GetMapping("/get/all")
    public List<Food> getAllFoods() {
        return foodService.findAllFoods();
    }

    @GetMapping("/get/{name}")
    public List<Food> getFoodsByName(@PathVariable String name) {
        return foodService.findFoodByName(name);
    }

    @GetMapping("/get/{id}")
    public Optional<Food> getFoodById(@PathVariable UUID id) {
        return foodService.findFoodById(id);
    }

    @GetMapping("/get/{foodType}")
    public List<Food> getFoodByType(@PathVariable String foodType) {
        return foodService.findFoodByType(foodType);
    }

    @PutMapping("/put/{id}")
    public UUID update(@PathVariable UUID id,
                       Food food) {
        return foodService.update(id, food);
    }

    @DeleteMapping("/delete/{id}")
    public UUID delete(@PathVariable UUID id) {
        return foodService.remove(id);
    }

}
