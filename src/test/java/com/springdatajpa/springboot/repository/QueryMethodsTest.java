package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("iphone 17");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products = productRepository.findByNameOrDescription("iphone 16", "iphone 17, the costliest iphone ever");
        products.forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> products = productRepository.findByNameAndDescription("iphone 16", "iphone 16, the costliest iphone ever");
        products.forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("iphone 17");
        System.out.println(product.getName());
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(300));
        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(1000));
        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products =productRepository.findByNameContaining("iphone");
        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("%mini%");
        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(500), new BigDecimal(2000));

        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        LocalDateTime startDate = LocalDateTime.of(2023, 06, 20, 21,00,00);
        LocalDateTime endDate = LocalDateTime.of(2023, 06, 25, 21,00,00);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Created Date: " + product.getDateCreated());
        });
    }

    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("iphone 17", "iphone 16"));

        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }

    @Test
    void findTop2ByNameContainingMethod(){
        List<Product> products = productRepository.findTop2ByNameContaining("iphone");

        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();

        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }

    @Test
    void findTop3ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();

        products.forEach(product -> {
            System.out.println("Name : " + product.getName() + " Price: " + product.getPrice());
        });
    }
}
