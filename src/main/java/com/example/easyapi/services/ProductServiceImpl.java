package com.example.easyapi.services;

import com.example.easyapi.dto.ProductWithOutIdDto;
import com.example.easyapi.dto.ProductDto;
import com.example.easyapi.dto.ProductWithGroupDto;
import com.example.easyapi.repository.ProductRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepositoryImpl productRepository;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductWithGroupDto> findAllByGroup(Long groupId) {
        return productRepository.findAllByGroup(groupId);
    }

    @Override
    public ProductDto create(ProductWithOutIdDto newProduct) {
        return productRepository.create(newProduct);
    }

    @Override
    public ProductDto update(ProductDto newProduct) {
        return productRepository.update(newProduct);
    }

    @Override
    public ProductDto findById(Long id) {
        return productRepository.findById(id);
    }

}
