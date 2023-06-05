package com.example.easyapi.dto;

import lombok.Data;

@Data
public class ProductWithGroupDto extends ProductDto {

    private Long group_id;

}
