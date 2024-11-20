package org.example.clothing_shop.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.example.clothing_shop.dto.ClothesDTO;
import org.example.clothing_shop.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    @Autowired
    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @GetMapping
    public ResponseEntity<Page<ClothesDTO>> getClothesPage(
            @RequestParam(defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(defaultValue = "10") @Min(1) @Max(100) Integer limit
    ) {
        Page<ClothesDTO> clothesPage = clothesService.getClothesPage(PageRequest.of(offset, limit));
        return ResponseEntity.ok(clothesPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothesDTO> getClothesById(@PathVariable String id) {
        ClothesDTO clothes = clothesService.getClothesById(id);
        return ResponseEntity.ok(clothes);
    }

    @PostMapping
    public ResponseEntity<ClothesDTO> createClothes(@RequestBody ClothesDTO clothesDTO) {
        ClothesDTO newClothes = clothesService.createClothes(clothesDTO);
        return new ResponseEntity<>(newClothes, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothesDTO> updateClothes(
            @PathVariable String id,
            @RequestBody ClothesDTO clothesDTO) {
        ClothesDTO updatedClothes = clothesService.updateClothes(id, clothesDTO);
        return ResponseEntity.ok(updatedClothes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothes(@PathVariable String id) {
        clothesService.deleteClothes(id);
        return ResponseEntity.noContent().build();
    }
}
