package com.example.easyapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Subgroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    private Groups group;

    @OneToMany(mappedBy="subgroup")
    private Set<Product> products;

}
