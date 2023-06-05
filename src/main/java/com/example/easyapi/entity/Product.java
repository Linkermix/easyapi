package com.example.easyapi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long number;

    @Column(unique = true, nullable = false)
    private String name;

    private String producer;

    private Double price;

    private Long amount;

    @ManyToOne
    @JoinColumn(name="subgroup_id", nullable=false)
    private Subgroups subgroup;

}
