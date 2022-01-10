package com.example.nnk.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection="Food")
@Getter
@Setter
public class Food {
    @Id
    private String _id;
    private String name;
    private int price;
    private String foodType;
    private String imgPath;
}
