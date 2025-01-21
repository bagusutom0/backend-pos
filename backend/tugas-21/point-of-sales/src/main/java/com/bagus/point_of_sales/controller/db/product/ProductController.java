package com.bagus.point_of_sales.controller.db.product;

import com.bagus.point_of_sales.service.db.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts () {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @Secured({"ROLE_CASHIER", "ROLE_MANAGER"})
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById (@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @Secured("ROLE_MANAGER")
    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(service.addProduct(request));
    }

    @Secured("ROLE_MANAGER")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequest request
    ) {
        return ResponseEntity.ok(service.updateProduct(id, request));
    }

    @Secured("ROLE_MANAGER")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);

        Map<String, String> response = new HashMap<>();
        String message = "Product with id " + id + " has been deleted successfully";
        response.put("message", message);
        return ResponseEntity.ok(response);
    }
}
