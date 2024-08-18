package com.makara.mini.project.service;

import com.makara.mini.project.entity.Brand;

import java.util.List;

public interface BrandService {
    Brand saveData(Brand brand);

    Brand getById(long id);

    Brand updateData(Long  id,Brand brand);

    List<Brand> listAll();

    Brand deleteById(Long id);
}
