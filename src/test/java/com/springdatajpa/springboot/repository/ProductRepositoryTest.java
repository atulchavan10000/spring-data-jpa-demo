package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // create a product object
        Product product = new Product();
        product.setName("galaxy 11");
        product.setDescription("android are trying but galaxy kills");
        product.setSku("aaq3r13aaaar");
        product.setPrice(new BigDecimal(10000));
        product.setActive(true);
        product.setImageUrl("url.com");

        // save product to db
        Product savedProduct = productRepository.save(product);

        // display product information
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct);
    }


    @Test
    void updateMethod(){
        // find the entity by id from db
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // updated the fetched entity
        product.setName("Updated name");
        product.setDescription("Updated description");

        // save the updated entity in db
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Optional<Product> product = productRepository.findById(1L);

        Product product2 = productRepository.findById(1L).get();

    }

    @Test
    void saveAllMethod(){
        Product product = new Product();
        product.setName("iphone 10");
        product.setDescription("iphone 10, the most usable iphone");
        product.setSku("q3r22aa13r");
        product.setPrice(new BigDecimal(2000));
        product.setActive(true);
        product.setImageUrl("url.com");


        Product product2 = new Product();
        product2.setName("iphone 12 mini");
        product2.setDescription("iphone 12 mini, the most handy iphone with awesomeness of all iphones");
        product2.setSku("q3ssraaaa13r");
        product2.setPrice(new BigDecimal(2000));
        product2.setActive(true);
        product2.setImageUrl("url.com");

        // save products to db
        productRepository.saveAll(List.of(product, product2));

    }

    @Test
    void findAllMethod(){
        List<Product> productList = productRepository.findAll();
        productList.forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void deleteByIdMethod(){
        productRepository.deleteById(1L);
    }

    @Test
    void deleteMethod(){
        // find an entity by id
        Product product = productRepository.findById(4L).get();

        // delete an entity
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){

        List<Product> productList = productRepository.findAll();

        // deletes only those products that have "iphone" in their names
        productRepository.deleteAll(
                productList.stream().filter(
                            product -> product.getName().contains("iphone")
                    ).collect(Collectors.toList())
        );

        // deletes all products
        productRepository.deleteAll();
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
    }

    @Test
    void existsByIdMethod(){
        boolean exists = productRepository.existsById(5L);
        System.out.println(exists);
    }
}