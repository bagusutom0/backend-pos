package com.bagus.point_of_sales.service.db;

import com.bagus.point_of_sales.controller.db.product.ProductDTO;
import com.bagus.point_of_sales.controller.db.product.ProductRequest;
import com.bagus.point_of_sales.model.product.Category;
import com.bagus.point_of_sales.model.product.CategoryRepository;
import com.bagus.point_of_sales.model.product.Product;
import com.bagus.point_of_sales.model.product.ProductRepository;
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
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductDTO addProduct(ProductRequest request) {

        Optional<Category> categoryOptional = categoryRepository.findById(request.getCategoryId());

        if (categoryOptional.isPresent()) {
            Product product = new Product();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setStock(request.getStock());
            product.setPrice(request.getPrice());
            product.setCategory(categoryOptional.get());
            Product savedProduct = productRepository.save(product);
            return ProductDTO.builder()
                    .id(savedProduct.getId())
                    .name(savedProduct.getName())
                    .description(savedProduct.getDescription())
                    .price(savedProduct.getPrice())
                    .stock(savedProduct.getStock())
                    .category(savedProduct.getCategory())
                    .build();
        } else {
            throw new EntityNotFoundException("Category not found");
        }
    }

    public List<ProductDTO> getAllPoducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .stock(product.getStock())
                        .category(product.getCategory())
                        .build())
                .collect(Collectors.toList());
    }

    public ProductDTO updateProduct(Long id, ProductRequest request) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Optional<Category> categoryOptional = categoryRepository.findById(request.getCategoryId());

            if (categoryOptional.isPresent()) {
                Product updatedProduct = productOptional.get();
                updatedProduct.setName(request.getName());
                updatedProduct.setDescription(request.getDescription());
                updatedProduct.setStock(request.getStock());
                updatedProduct.setPrice(request.getPrice());
                updatedProduct.setCategory(categoryOptional.get());

                Product savedProduct = productRepository.save(updatedProduct);
                return ProductDTO.builder()
                        .id(savedProduct.getId())
                        .name(savedProduct.getName())
                        .description(savedProduct.getDescription())
                        .price(savedProduct.getPrice())
                        .stock(savedProduct.getStock())
                        .category(savedProduct.getCategory())
                        .build();
            } else {
                throw new EntityNotFoundException("Category not found");
            }
        } else {
            throw new EntityNotFoundException("Product not found");
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
