/*
package org.example.clothing_shop.runner;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.example.clothing_shop.model.Clothes;
import org.example.clothing_shop.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component
public class ClothesDataGenerator {

    private final ClothesRepository clothesRepository;
    private final Faker faker = new Faker();
    private final Random random = new Random();

    @Autowired
    public ClothesDataGenerator(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    @PostConstruct
    public void generateData() {
        if (clothesRepository.count() == 0) {
            for (int i = 0; i < 20; i++) {
                Clothes clothes = new Clothes();
                clothes.setName(faker.commerce().productName());
                clothes.setCategory(faker.options().option("T-Shirts", "Jeans", "Jackets", "Shoes", "Accessories"));
                clothes.setPrice(Double.parseDouble(faker.commerce().price(10.0, 200.0)));
                clothes.setSizes(Arrays.asList("S", "M", "L", "XL").subList(0, random.nextInt(4) + 1));
                clothes.setColors(Arrays.asList("Red", "Blue", "Black", "White", "Green").subList(0, random.nextInt(5) + 1));
                clothes.setStock((double) random.nextInt(100));
                clothes.setBrand(faker.company().name());
                clothes.setDescription(faker.lorem().sentence(10));
                clothesRepository.save(clothes);
            }
        }
    }
}
*/
