package com.example.nnk.service;

import com.example.nnk.domain.Food;
import com.example.nnk.repository.FoodRepository;
import com.example.nnk.repository.MongoFoodRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class FoodServiceTest {

    FoodRepository foodRepository;
    FoodService foodService;

    @BeforeEach
    void setUp() {
        foodRepository = new MongoFoodRepository();
        foodService = new FoodService(foodRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        food.setFoodType("면, 밀가루");

        // when
        String saveId = foodService.add(food);

        // then
        Food findFood = foodService.findFoodById(saveId).get();
        assertThat(food.getName()).isEqualTo(findFood.getName());
    }

    @Test
    void findAllFoods() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        food.setFoodType("면, 밀가루");
        foodService.add(food);

        Food food2 = new Food();
        food2.setName("치즈 라면");
        food2.setPrice(2500);
        food2.setImgPath("..");
        food2.setFoodType("면, 밀가루, 치즈");
        foodService.add(food2);

        Food food3 = new Food();
        food3.setName("원조 김밥");
        food3.setPrice(2000);
        food3.setImgPath("..");
        food3.setFoodType("밥, 김밥");
        foodService.add(food3);

        // when
        List<Food> findFoods = foodService.findAllFoods();

        // then

    }

    @Test
    void findFoodByName() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        food.setFoodType("면, 밀가루");
        foodService.add(food);

        Food food2 = new Food();
        food2.setName("치즈 라면");
        food2.setPrice(2500);
        food2.setImgPath("..");
        food2.setFoodType("면, 밀가루, 치즈");
        foodService.add(food2);

        Food food3 = new Food();
        food3.setName("원조 김밥");
        food3.setPrice(2000);
        food3.setImgPath("..");
        food3.setFoodType("밥, 김밥");
        foodService.add(food3);

        // when
        List<Food> findFoods = foodService.findFoodByName("라면");

        // then
    }

    @Test
    void findFoodByType() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        food.setFoodType("면, 밀가루");
        foodService.add(food);

        Food food2 = new Food();
        food2.setName("치즈 김치 음밥");
        food2.setPrice(3500);
        food2.setImgPath("..");
        food2.setFoodType("밥, 치즈");
        foodService.add(food2);

        Food food3 = new Food();
        food3.setName("원조 김밥");
        food3.setPrice(2000);
        food3.setImgPath("..");
        food3.setFoodType("밥, 김밥");
        foodService.add(food3);

        // when
        List<Food> findFoods = foodService.findFoodByType("밥");

        // then
    }

    @Test
    void update() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        food.setFoodType("면, 밀가루");
        String saveId = foodService.add(food);

        // when
        food.setPrice(2000);
        food.setFoodType("면, 밀가루, 매움");
        String newId = foodService.update(saveId, food);

        // then
        Food findFood = foodService.findFoodById(newId).get();
        assertThat(saveId).isEqualTo(newId);
        assertThat(food.getPrice()).isEqualTo(findFood.getPrice());
        assertThat(food.getFoodType()).isEqualTo(findFood.getFoodType());
    }

    @Test
    void remove() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        food.setFoodType("면, 밀가루");
        String saveId = foodService.add(food);

        // when
        String deleteId = foodService.remove(saveId);

        // then
        Food findFood = foodService.findFoodById(deleteId).get();
        assertThat(saveId).isEqualTo(deleteId);
        assertThat(findFood).isEqualTo(null);
    }
}