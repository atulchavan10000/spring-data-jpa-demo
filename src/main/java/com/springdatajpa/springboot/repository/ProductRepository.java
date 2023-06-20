package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);
    public Optional<Product> findById(Long id);

    public List<Product> findByNameOrDescription(String name, String description);

    public List<Product> findByNameAndDescription(String name, String description);

    public Product findDistinctByName(String name);

    public List<Product> findByPriceGreaterThan(BigDecimal price);

    public List<Product> findByPriceLessThan(BigDecimal price);

    public List<Product> findByNameContaining(String name);

    public List<Product> findByNameLike(String name);

    public List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    public List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    public List<Product> findByNameIn(List<String> names);

    public List<Product> findTop2ByNameContaining(String name);

    public List<Product> findFirst2ByOrderByNameAsc();

    public List<Product> findTop3ByOrderByPriceDesc();
}

