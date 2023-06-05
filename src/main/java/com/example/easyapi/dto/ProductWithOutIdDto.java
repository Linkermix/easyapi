package com.example.easyapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductWithOutIdDto {

    @Schema(defaultValue = "100335")
    private Long number;

    @Schema(defaultValue = "IBM 486")
    private String name;

    @Schema(defaultValue = "IBM")
    private String producer;

    @Schema(defaultValue = "5000")
    private Double price;

    @Schema(defaultValue = "1")
    private Long amount;

    @Schema(defaultValue = "1")
    private Long subgroup_id;

}
