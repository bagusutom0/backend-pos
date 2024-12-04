package com.bagus.gen_24_java_springboot_pos.controller.pos;

import com.bagus.gen_24_java_springboot_pos.entity.category.Category;
import com.bagus.gen_24_java_springboot_pos.service.db.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(service.createCategory(category));
    }

    @GetMapping("/native")
    public ResponseEntity<List<Category>> getAllCategoryNative() {
        return ResponseEntity.ok(service.getAllCategoryNative());
    }

    @GetMapping("/jpql")
    public ResponseEntity<List<Category>> getAllCategoryJpql() {
        return ResponseEntity.ok(service.getAllCategoryJpql());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Category>> getFilteredCategory(
        @RequestParam(required = false) String name
    ) {
        return ResponseEntity.ok(service.filterCategories(name));
    }
}
