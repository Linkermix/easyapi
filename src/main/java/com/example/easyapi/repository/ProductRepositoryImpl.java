package com.example.easyapi.repository;

import com.example.easyapi.dto.ProductWithOutIdDto;
import com.example.easyapi.dto.ProductDto;
import com.example.easyapi.dto.ProductWithGroupDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


@Repository
@AllArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public ProductDto create(ProductWithOutIdDto entity) {

        final String insertIntoSql =
        "insert into product (amount, name, subgroup_id, number, price, producer) values (?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertIntoSql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,entity.getAmount());
            ps.setString(2,entity.getName());
            ps.setLong(3,entity.getSubgroup_id());
            ps.setLong(4,entity.getNumber());
            ps.setDouble(5,entity.getPrice());
            ps.setString(6,entity.getProducer());
            return ps;
        }, keyHolder);
        } catch (Exception ex) {
            log.info("Failed to create new product with exception: " + ex.getMessage());
        }
        return findById(keyHolder.getKey().longValue());
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        try {
            jdbcTemplate.update(
                    "update product set amount=?, name=?, subgroup_id=?, number=?, price=?, producer=? where id=?",
                    new Object[]{
                            productDto.getAmount(),
                            productDto.getName(),
                            productDto.getSubgroup_id(),
                            productDto.getNumber(),
                            productDto.getPrice(),
                            productDto.getProducer(),
                            productDto.getId()
                    });
        } catch (Exception ex) {
            log.info("Failed to update product with exception: " + ex.getMessage());
        }
        return findById(productDto.getId());
    }

    @Override
    public ProductDto findById(Long id) {
        return jdbcTemplate.queryForObject("select * from product where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(ProductDto.class));
    }

    @Override
    public List<ProductDto> findAll() {
        return jdbcTemplate.query("select * from product", new BeanPropertyRowMapper<>(ProductDto.class));
    }

    @Override
    public List<ProductWithGroupDto> findAllByGroup(Long groupId) {
        return jdbcTemplate.query("select * from product p left join subgroups s on p.subgroup_id=s.id where s.group_id=?",
                new Object[]{groupId}, new BeanPropertyRowMapper<>(ProductWithGroupDto.class));
    }
}