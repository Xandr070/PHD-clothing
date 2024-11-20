package org.example.clothing_shop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClothesDTO {
    private String id;
    private String name;
    private String category;
    private Double price;
    private List<String> sizes;
    private List<String> colors;
    private Double stock;
    private String brand;
    private String description;

}
