package org.example.clothing_shop.service.serviceImpl;

import org.example.clothing_shop.dto.ClothesDTO;
import org.example.clothing_shop.exception.ClothesNotFoundException;
import org.example.clothing_shop.mapper.ClothesMapper;
import org.example.clothing_shop.model.Clothes;
import org.example.clothing_shop.repository.ClothesRepository;
import org.example.clothing_shop.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService {

    private final ClothesRepository clothesRepository;
    private final ClothesMapper clothesMapper;

    @Autowired
    public ClothesServiceImpl(ClothesRepository clothesRepository, ClothesMapper clothesMapper) {
        this.clothesRepository = clothesRepository;
        this.clothesMapper = clothesMapper;
    }

    @Override
    public List<ClothesDTO> getAllClothes() {
        List<Clothes> clothesList = clothesRepository.findAll();
        return clothesMapper.toDTOList(clothesList);
    }

    @Override
    public Page<ClothesDTO> getClothesPage(Pageable pageable) {
        Page<Clothes> clothesPage = clothesRepository.findAll(pageable);
        return clothesPage.map(clothesMapper::clothesToDTO);
    }

    @Override
    public ClothesDTO getClothesById(String id) {
        Clothes clothes = clothesRepository.findById(id)
                .orElseThrow(() -> new ClothesNotFoundException("Clothes not found with id: " + id));
        return clothesMapper.clothesToDTO(clothes);
    }

    @Override
    public ClothesDTO createClothes(ClothesDTO clothesDTO) {
        Clothes clothes = clothesMapper.toEntity(clothesDTO);
        Clothes savedClothes = clothesRepository.save(clothes);
        return clothesMapper.clothesToDTO(savedClothes);
    }

    @Override
    public ClothesDTO updateClothes(String id, ClothesDTO clothesDTO) {
        Clothes existingClothes = clothesRepository.findById(id)
                .orElseThrow(() -> new ClothesNotFoundException("Clothes not found with id: " + id));

        existingClothes.setName(clothesDTO.getName());
        existingClothes.setCategory(clothesDTO.getCategory());
        existingClothes.setPrice(clothesDTO.getPrice());
        existingClothes.setSizes(clothesDTO.getSizes());
        existingClothes.setColors(clothesDTO.getColors());
        existingClothes.setStock(clothesDTO.getStock());
        existingClothes.setBrand(clothesDTO.getBrand());
        existingClothes.setDescription(clothesDTO.getDescription());

        Clothes updatedClothes = clothesRepository.save(existingClothes);
        return clothesMapper.clothesToDTO(updatedClothes);
    }

    @Override
    public void deleteClothes(String id) {
        Clothes clothes = clothesRepository.findById(id)
                .orElseThrow(() -> new ClothesNotFoundException("Clothes not found with id: " + id));
        clothesRepository.delete(clothes);
    }
}
