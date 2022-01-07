package com.example.nnk;

import com.example.nnk.domain.Food;
import com.example.nnk.repository.FoodRepository;
import com.example.nnk.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final FoodRepository foodRepository;

    @Autowired
    public SpringConfig(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Bean
    public FoodService foodService() {
        return new FoodService(foodRepository);
    }

}
