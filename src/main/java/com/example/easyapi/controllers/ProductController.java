package com.example.easyapi.controllers;

import com.example.easyapi.dto.ProductWithOutIdDto;
import com.example.easyapi.dto.ProductDto;
import com.example.easyapi.dto.ProductWithGroupDto;
import com.example.easyapi.services.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@AllArgsConstructor
class ProductController {

    private ProductServiceImpl productService;

    @GetMapping("list")
    public ResponseEntity<List<ProductDto>> list() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("listByGroup")
    public ResponseEntity<List<ProductWithGroupDto>> listByGroup(@RequestParam(defaultValue = "1", required = false) Long groupId) {
        return ResponseEntity.ok(productService.findAllByGroup(groupId));
    }

    @PostMapping("create")
    public ResponseEntity<ProductDto> create(ProductWithOutIdDto newProduct) {
        try {
            return ResponseEntity.ok(productService.create(newProduct));
        } catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("update")
    public ResponseEntity<ProductDto> update(ProductDto newProduct) {
        try {
            return ResponseEntity.ok(productService.update(newProduct));
        } catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("get")
    public ResponseEntity<ProductDto> get(@RequestParam(defaultValue = "1", required = true) Long id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }
}
