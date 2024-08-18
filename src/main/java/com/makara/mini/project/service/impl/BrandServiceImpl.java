package com.makara.mini.project.service.impl;

import com.makara.mini.project.entity.Brand;
import com.makara.mini.project.exception.ApiException;
import com.makara.mini.project.exception.ResourceNotFoundException;
import com.makara.mini.project.exception.SuccessResponse;
import com.makara.mini.project.repository.BrandRepository;
import com.makara.mini.project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand saveData(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(long id){
//        Optional<Brand> brand = brandRepository.findById(id);
//        if(brand.isPresent()) {
//            return brand.get();
//        }
//        throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id = " + id);

        return brandRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("brand",id));
    }

    @Override
    public Brand updateData(Long id ,Brand brand) {
        Brand dataUpdate = getById(id);
        dataUpdate.setName(brand.getName());
        return brandRepository.save(dataUpdate);
    }

    @Override
    public List<Brand> listAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand deleteById(Long id) {
        Brand byId = getById(id);
        brandRepository.delete(byId);
//        return byId;
        return brandRepository.findById(id).
                orElseThrow(()->new SuccessResponse("brand",id));
    }
}
