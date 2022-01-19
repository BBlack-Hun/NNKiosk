package com.example.nnk.repository;

import com.example.nnk.domain.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MongoFoodRepository extends MongoRepository<Food, String>, FoodRepository {
    @Query("{name : {$regex : ?0 } }")
    public List<Food> findAllFoodsByName(String name);
    
    // Not error!
    public List<Food> findAllByfoodTypesIn(String foodTypes);
}
