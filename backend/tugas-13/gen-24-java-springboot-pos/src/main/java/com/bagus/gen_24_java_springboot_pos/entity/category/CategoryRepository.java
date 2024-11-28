package com.bagus.gen_24_java_springboot_pos.entity.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    @Query(value = "SELECT * FROM category", nativeQuery = true)
    List<Category> findAllCategoryNative();

    @Query("SELECT c FROM Category c")
    List<Category> findAllCategoryJpql();
}
