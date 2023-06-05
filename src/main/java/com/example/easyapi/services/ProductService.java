package com.example.easyapi.services;

import com.example.easyapi.dto.ProductDto;
import com.example.easyapi.dto.ProductWithGroupDto;
import com.example.easyapi.dto.ProductWithOutIdDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {

    public List<ProductDto> findAll();

    List<ProductWithGroupDto> findAllByGroup(Long groupId);

    public ProductDto findById(@RequestParam Long id);

    public ProductDto create(ProductWithOutIdDto newProduct);

    public ProductDto update(ProductDto newProduct);
}
