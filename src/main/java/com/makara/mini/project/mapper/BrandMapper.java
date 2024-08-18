package com.makara.mini.project.mapper;

import com.makara.mini.project.dto.BrandDTO;
import com.makara.mini.project.entity.Brand;

public class BrandMapper {

    public static Brand toBrand(BrandDTO dto) {
        Brand brand = new Brand();
        brand.setName(dto.getName());
        return brand;
    }

    public static BrandDTO toDto(Brand entity) {
        BrandDTO dto = new BrandDTO();
        dto.setName(entity.getName());
        dto.setId(entity.getId());

        return dto;
    }
}
