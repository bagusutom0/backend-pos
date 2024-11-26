package com.bagus.gen_24_java_spring_framework.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends JpaRepository<Product, Long> {
}
