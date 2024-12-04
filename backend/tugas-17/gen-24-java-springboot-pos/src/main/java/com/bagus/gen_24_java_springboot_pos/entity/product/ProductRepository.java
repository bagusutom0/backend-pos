package com.bagus.gen_24_java_springboot_pos.entity.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query(value = "SELECT p FROM Product p")
    List<Product> findAllProductJpql();

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> findAllProductNative();
}
