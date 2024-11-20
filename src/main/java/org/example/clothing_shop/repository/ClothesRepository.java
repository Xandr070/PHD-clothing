package org.example.clothing_shop.repository;

import org.example.clothing_shop.model.Clothes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothesRepository extends MongoRepository<Clothes, String> {

    Optional<Clothes> getByName(String name);

    List<Clothes> findByCategory(String category);

    List<Clothes> findByBrand(String brand);

    List<Clothes> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Clothes> findBySizesContaining(String size);

    List<Clothes> findByColorsContaining(String color);

    List<Clothes> findByStockLessThan(Double stock);
}