package com.example.nnk;

import com.example.nnk.food.repository.MongoFoodRepository;
import com.example.nnk.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {
    private final MongoFoodRepository foodRepository;

    @Autowired
    public SpringConfig(MongoFoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Bean
    public FoodService foodService() {
        return new FoodService(foodRepository);
    }
}
