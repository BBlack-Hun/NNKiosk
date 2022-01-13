package com.example.nnk.service;

import com.example.nnk.domain.Food;
import com.example.nnk.repository.MongoFoodRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class FoodServiceTest {
    @Autowired
    MongoFoodRepository foodRepository;
    @Autowired FoodService foodService;
    List<String> types = new ArrayList<>();

    @AfterEach
    void tearDown() {
       foodRepository.deleteAll();
    }

    // 추가
    @Test
    void add() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        food.setFoodTypes(types);

        types.clear();

        // when
        String saveId = foodService.add(food);

        // then
        Food findFood = foodService.findFoodById(saveId).get();
        assertThat(food.getName()).isEqualTo(findFood.getName());
    }

    // 모두 찾기
    @Test
    void findAllFoods() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        food.setFoodTypes(types);
        foodService.add(food);

        types.clear();

        Food food2 = new Food();
        food2.setName("치즈 라면");
        food2.setPrice(2500);
        food2.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        types.add("치즈");
        food2.setFoodTypes(types);
        foodService.add(food2);

        types.clear();

        Food food3 = new Food();
        food3.setName("원조 김밥");
        food3.setPrice(2000);
        food3.setImgPath("..");
        types.add("밥");
        types.add("김밥");
        types.add("야채");
        food3.setFoodTypes(types);
        foodService.add(food3);

        types.clear();

        // when
        List<Food> findFoods = foodService.findAllFoods();

        // then
        assertThat(findFoods.size()).isEqualTo(3);
    }

    // 여러개 업데이트
    @Test
    void updateAllFoods() {
        // given
        Food food = new Food();
        food.setName("치즈 라면");
        food.setPrice(1500);
        food.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        food.setFoodTypes(types);
        String saveId = foodService.add(food);
        food = foodService.findFoodById(saveId).get();

        types.clear();

        Food food2 = new Food();
        food2.setName("치즈 라면");
        food2.setPrice(2500);
        food2.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        types.add("치즈");
        food2.setFoodTypes(types);
        String saveId2 = foodService.add(food2);
        food2 = foodService.findFoodById(saveId2).get();

        types.clear();

        // when
        food.setPrice(2000);
        food.setImgPath("../../img");

        food2.setName("치즈 가득 라면");
        food2.setPrice(3000);

        List<Food> updateFoods = new ArrayList<>();
        updateFoods.add(food);
        updateFoods.add(food2);

        updateFoods = foodService.updateAllFoods(updateFoods);

        // then
        assertThat(updateFoods.size()).isEqualTo(2);
        assertThat(updateFoods.contains(food)).isEqualTo(true);
        assertThat(updateFoods.contains(food2)).isEqualTo(true);
    }

    // 하나 업데이트
    @Test
    void update() {
        // given
        Food food = new Food();
        food.setName("치즈 라면");
        food.setPrice(1500);
        food.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        food.setFoodTypes(types);
        String saveId = foodService.add(food);

        // when
        food.setPrice(2000);
        types.add("치즈");
        food.setFoodTypes(types);
        String newId = foodService.update(saveId, food);

        // then
        Food findFood = foodService.findFoodById(newId).get();
        assertThat(saveId).isEqualTo(newId);
        assertThat(food.getPrice()).isEqualTo(findFood.getPrice());
        assertThat(food.getFoodTypes()).isEqualTo(findFood.getFoodTypes());
        types.clear();
    }

    // 하나 삭제
    @Test
    void remove() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        food.setFoodTypes(types);
        types.clear();

        String saveId = foodService.add(food);

        // when
        String deleteId = foodService.remove(saveId);

        // then
        List<Food> findFoods = foodService.findAllFoods();
        assertThat(saveId).isEqualTo(deleteId);
        assertThat(findFoods.size()).isEqualTo(0);
    }

    // 이름으로 찾기
    @Test
    void findFoodsByName() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        food.setFoodTypes(types);
        foodService.add(food);

        types.clear();

        Food food2 = new Food();
        food2.setName("치즈 라면");
        food2.setPrice(2500);
        food2.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        types.add("치즈");
        food2.setFoodTypes(types);
        foodService.add(food2);

        types.clear();

        Food food3 = new Food();
        food3.setName("원조 김밥");
        food3.setPrice(2000);
        food3.setImgPath("..");
        types.add("밥");
        types.add("김밥");
        types.add("야채");
        food3.setFoodTypes(types);
        foodService.add(food3);

        types.clear();

        // when
        List<Food> findFoods = foodService.findFoodsByName("라면");

        // then
        assertThat(findFoods.size()).isEqualTo(2);
    }

    // 타입으로 찾기
    @Test
    void findFoodByType() {
        // given
        Food food = new Food();
        food.setName("라면");
        food.setPrice(1500);
        food.setImgPath("..");
        types.add("면");
        types.add("밀가루");
        food.setFoodTypes(types);
        foodService.add(food);

        types.clear();

        Food food2 = new Food();
        food2.setName("야채 튀김");
        food2.setPrice(2000);
        food2.setImgPath("..");
        types.add("야채");
        types.add("밀가루");
        food2.setFoodTypes(types);
        foodService.add(food2);

        types.clear();

        Food food3 = new Food();
        food3.setName("원조 김밥");
        food3.setPrice(2000);
        food3.setImgPath("..");
        types.add("밥");
        types.add("김밥");
        types.add("야채");
        food3.setFoodTypes(types);
        foodService.add(food3);

        types.clear();

        // when
        List<Food> findFoods = foodService.findFoodsByType("밀가루");

        // then
        assertThat(findFoods.size()).isEqualTo(2);
    }
}