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
    public List<Food> getAllFoods() {
        return foodService.findAllFoods();
    }

    @GetMapping("/{name}")
    public List<Food> getFoodsByName(@PathVariable String name) {
        return foodService.findFoodByName(name);
    }

    @GetMapping("/{id}")
    public Optional<Food> getFoodById(@PathVariable String id) {
        return foodService.findFoodById(id);
    }

    @GetMapping("/{foodType}")
    public List<Food> getFoodByType(@PathVariable String foodType) {
        return foodService.findFoodByType(foodType);
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

}
