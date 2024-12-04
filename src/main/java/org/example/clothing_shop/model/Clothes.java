package org.example.clothing_shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Clothing_shop")
@Data
@NoArgsConstructor
public class Clothes {
    @Id
    private String id;
    private Double stock;
    private Double price;
    private List<String> colors;
    private List<String> sizes;
    private String description;

    @Indexed(unique = false, sparse = true, direction = IndexDirection.ASCENDING, background = false)
    private String brand;

    @Indexed(unique = false, sparse = true, direction = IndexDirection.ASCENDING, background = false)
    private String category;

    @Indexed(unique = false, sparse = true, direction = IndexDirection.ASCENDING, background = false)
    private String name;
}