package org.example.clothing_shop.service;

import org.example.clothing_shop.dto.ClothesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClothesService {

    List<ClothesDTO> getAllClothes();

    Page<ClothesDTO> getClothesPage(Pageable pageable);

    ClothesDTO getClothesById(String id);

    ClothesDTO createClothes(ClothesDTO clothesDTO);

    ClothesDTO updateClothes(String id, ClothesDTO clothesDTO);

    void deleteClothes(String id);
}
