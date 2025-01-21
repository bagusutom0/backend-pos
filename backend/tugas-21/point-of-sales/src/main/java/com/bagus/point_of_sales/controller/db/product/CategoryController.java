package com.bagus.point_of_sales.controller.db.product;

import com.bagus.point_of_sales.service.db.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        return ResponseEntity.ok(service.getAllCategories());
    }

    @Secured({"ROLE_CASHIER", "ROLE_MANAGER"})
    @GetMapping("/{name}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable String name) {
        return ResponseEntity.ok(service.getCategoryByName(name));
    }

    @Secured("ROLE_MANAGER")
    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(service.addCategory(request));
    }

    @Secured("ROLE_MANAGER")
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryRequest request
    ) {
        return ResponseEntity.ok(service.updateCategoryName(id, request));
    }

    @Secured("ROLE_MANAGER")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);

        Map<String, String> response = new HashMap<>();
        String message = "Category with id " + id + " has been deleted successfully";
        response.put("message", message);
        return ResponseEntity.ok(response);
    }
}