package com.bagus.gen_24_java_springboot_pos.service;

import com.bagus.gen_24_java_springboot_pos.entity.category.Category;
import com.bagus.gen_24_java_springboot_pos.entity.category.CategoryRepository;
import com.bagus.gen_24_java_springboot_pos.entity.category.CategorySpecifications;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<Category> filterCategories(String name){
        Specification<Category> spec = Specification.where(CategorySpecifications.hasName(name));
        return repository.findAll(spec);
    }

    public List<Category> getAllCategoryNative() {
        return repository.findAllCategoryNative();
    }

    public List<Category> getAllCategoryJpql() {
        return repository.findAllCategoryJpql();
    }

    public Category createCategory(Category category) {
        return repository.save(category);
    }


    public Category updateCategory(Long id, Category updatedCategory) {
        return repository.findById(id)
                .map(category -> {
                    category.setName(updatedCategory.getName());
                    return repository.save(category);
                })
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
