package com.example.easyapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductDto extends ProductWithOutIdDto {

    @Schema(defaultValue = "1")
    private Long id;

}
