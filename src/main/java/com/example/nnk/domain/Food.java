package com.example.nnk.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;


@Document(collection="Food")
@Data
@Getter
@Setter
public class Food {
    @Id
    private String _id;
    private String name;
    private int price;
    private List<String> foodTypes;
    private String imgPath;
    private Map<String, Integer> ingredients;   // ingredients _id : how many use
}
