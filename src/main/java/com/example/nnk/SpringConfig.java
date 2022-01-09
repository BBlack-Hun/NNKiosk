package com.example.nnk;

import com.example.nnk.repository.FoodRepository;
import com.example.nnk.repository.MongoFoodRepository;
import com.example.nnk.service.FoodService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean
    public FoodRepository foodRepository() {
        return new MongoFoodRepository();
    }

    @Bean
    public FoodService foodService() {
        return new FoodService(foodRepository());
    }

}
