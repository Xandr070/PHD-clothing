package org.example.clothing_shop.mapper;

import org.example.clothing_shop.dto.ClothesDTO;
import org.example.clothing_shop.model.Clothes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClothesMapper {
    ClothesDTO clothesToDTO(Clothes clothes);
    Clothes toEntity(ClothesDTO clothesDTO);
    List<ClothesDTO> toDTOList(List<Clothes> clothesList);
    List<Clothes> toEntityList(List<ClothesDTO> clothesDTOList);
}

