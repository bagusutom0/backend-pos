package com.bagus.point_of_sales.service.db;

import com.bagus.point_of_sales.controller.db.product.CategoryDTO;
import com.bagus.point_of_sales.controller.db.product.CategoryRequest;
import com.bagus.point_of_sales.model.product.Category;
import com.bagus.point_of_sales.model.product.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDTO addCategory(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        Category savedCategory = categoryRepository.save(category);
        return CategoryDTO.builder()
                .id(savedCategory.getId())
                .name(savedCategory.getName())
                .build();
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        return CategoryDTO.builder().id(category.getId()).name(category.getName()).build();
    }

    public CategoryDTO updateCategoryName(Long id, CategoryRequest request) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            Category updatedCategory = categoryOptional.get();
            updatedCategory.setName(request.getName());
            Category savedCategory = categoryRepository.save(updatedCategory);
            return CategoryDTO.builder()
                    .id(savedCategory.getId())
                    .name(savedCategory.getName())
                    .build();
        } else {
            throw new EntityNotFoundException("Category not found");
        }
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
