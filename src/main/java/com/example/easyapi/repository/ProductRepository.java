package com.example.easyapi.repository;

import com.example.easyapi.dto.ProductWithOutIdDto;
import com.example.easyapi.dto.ProductDto;
import com.example.easyapi.dto.ProductWithGroupDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    public ProductDto create(ProductWithOutIdDto productDto);

    public ProductDto update(ProductDto productDto);

    public ProductDto findById(Long id);

    public List<ProductDto> findAll();

    public List<ProductWithGroupDto> findAllByGroup(Long groupId);

    }
