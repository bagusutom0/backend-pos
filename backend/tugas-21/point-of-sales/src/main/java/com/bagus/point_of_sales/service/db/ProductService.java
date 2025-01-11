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
            product.setImage(request.getImage());
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setReview(request.getReview());
            product.setDescription(request.getDescription());
            product.setColour(request.getColour());
            product.setSize(request.getSize());
            product.setLength(request.getLength());
            product.setStock(request.getStock());
            product.setCategory(categoryOptional.get());
            Product savedProduct = productRepository.save(product);
            return ProductDTO.builder()
                    .id(savedProduct.getId())
                    .image(savedProduct.getImage())
                    .name(savedProduct.getName())
                    .price(savedProduct.getPrice())
                    .review(savedProduct.getReview())
                    .description(savedProduct.getDescription())
                    .colour(savedProduct.getColour())
                    .size(savedProduct.getSize())
                    .length(savedProduct.getLength())
                    .stock(savedProduct.getStock())
                    .category(savedProduct.getCategory())
                    .build();
        } else {
            throw new EntityNotFoundException("Category not found");
        }
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .image(product.getImage())
                        .name(product.getName())
                        .price(product.getPrice())
                        .review(product.getReview())
                        .description(product.getDescription())
                        .colour(product.getColour())
                        .size(product.getSize())
                        .length(product.getLength())
                        .stock(product.getStock())
                        .category(product.getCategory())
                        .build())
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return ProductDTO.builder()
                    .id(product.getId())
                    .image(product.getImage())
                    .name(product.getName())
                    .price(product.getPrice())
                    .review(product.getReview())
                    .description(product.getDescription())
                    .colour(product.getColour())
                    .size(product.getSize())
                    .length(product.getLength())
                    .stock(product.getStock())
                    .category(product.getCategory())
                    .build();
        } else {
            throw new EntityNotFoundException("Product not found");
        }
    }

    public ProductDTO updateProduct(Long id, ProductRequest request) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Optional<Category> categoryOptional = categoryRepository.findById(request.getCategoryId());

            if (categoryOptional.isPresent()) {
                Product updatedProduct = productOptional.get();
                updatedProduct.setImage(request.getImage());
                updatedProduct.setName(request.getName());
                updatedProduct.setPrice(request.getPrice());
                updatedProduct.setReview(request.getReview());
                updatedProduct.setDescription(request.getDescription());
                updatedProduct.setColour(request.getColour());
                updatedProduct.setSize(request.getSize());
                updatedProduct.setLength(request.getLength());
                updatedProduct.setStock(request.getStock());
                updatedProduct.setCategory(categoryOptional.get());

                Product savedProduct = productRepository.save(updatedProduct);
                return ProductDTO.builder()
                        .id(savedProduct.getId())
                        .image(savedProduct.getImage())
                        .name(savedProduct.getName())
                        .price(savedProduct.getPrice())
                        .review(savedProduct.getReview())
                        .description(savedProduct.getDescription())
                        .colour(savedProduct.getColour())
                        .size(savedProduct.getSize())
                        .length(savedProduct.getLength())
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
