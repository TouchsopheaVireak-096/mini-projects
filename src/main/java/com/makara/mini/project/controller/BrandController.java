package com.makara.mini.project.controller;

import com.makara.mini.project.dto.BrandDTO;
import com.makara.mini.project.entity.Brand;
import com.makara.mini.project.mapper.BrandMapper;
import com.makara.mini.project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> saveData(@RequestBody BrandDTO dto) {
        Brand brand = BrandMapper.toBrand(dto);
        Brand saveData = brandService.saveData(brand);

        BrandDTO dto2 = BrandMapper.toDto(saveData);
        return ResponseEntity.ok(dto2);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Brand getData = brandService.getById(id);
        BrandDTO dto2 = BrandMapper.toDto(getData);

        return ResponseEntity.ok(dto2);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BrandDTO dto) {
        Brand brand = BrandMapper.toBrand(dto);
        Brand update = brandService.updateData(id, brand);
        BrandDTO dto2 = BrandMapper.toDto(update);
        return ResponseEntity.ok(dto2);
    }

    @GetMapping
    public ResponseEntity<?> getAllEntity() {
        List<Brand> listAll = brandService.listAll();
        return ResponseEntity.ok(listAll);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        brandService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
