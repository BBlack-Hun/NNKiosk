package com.example.nnk.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection="Food")
public class Food {
    private UUID id;
    private String name;
    private int price;
    private String foodType;
    private String imgPath;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getImgPath() {
        return imgPath;
    }
}
