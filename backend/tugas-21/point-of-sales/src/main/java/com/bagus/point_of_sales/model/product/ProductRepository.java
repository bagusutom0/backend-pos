package com.bagus.point_of_sales.model.product;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name, Sort sort);
    List<Product> findByCategoryId(Long categoryId, Sort sort);
    List<Product> findByNameContainingIgnoreCaseAndCategoryId(String name, Long categoryId, Sort sort);
}
