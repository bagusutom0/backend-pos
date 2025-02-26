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
import org.springframework.data.domain.Sort;
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
            product.setCategory(categoryOptional.get());
            Product savedProduct = productRepository.save(product);
            return ProductDTO.builder()
                    .id(savedProduct.getId())
                    .image(savedProduct.getImage())
                    .name(savedProduct.getName())
                    .price(savedProduct.getPrice())
                    .category(new ProductDTO.CategoryDTO(savedProduct.getCategory()))
                    .build();
        } else {
            throw new EntityNotFoundException("Category not found");
        }
    }

    public List<ProductDTO> getAllProducts(String name, Long category_id, String sort_by, String sort_order) {
        if (sort_by == null || sort_by.isEmpty()) {
            sort_by = "category";
        }

        if (sort_order == null || sort_order.isEmpty()) {
            sort_order = "asc";
        }

        Sort.Order order = sort_order.equalsIgnoreCase("asc") ? Sort.Order.asc(sort_by) : Sort.Order.desc(sort_by);

        Sort sort = Sort.by(order);

        List<Product> products;

        if (name != null && !name.isEmpty() && category_id != null) {
            products = productRepository.findByNameContainingIgnoreCaseAndCategoryId(name, category_id, sort);
        } else if (name != null && !name.isEmpty()) {
            products = productRepository.findByNameContainingIgnoreCase(name, sort);
        } else if (category_id != null) {
            products = productRepository.findByCategoryId(category_id, sort);
        } else {
            products = productRepository.findAll(sort);
        }
        return products.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .image(product.getImage())
                        .name(product.getName())
                        .price(product.getPrice())
                        .category(new ProductDTO.CategoryDTO(product.getCategory()))
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
                    .category(new ProductDTO.CategoryDTO(product.getCategory()))
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
                updatedProduct.setCategory(categoryOptional.get());

                Product savedProduct = productRepository.save(updatedProduct);
                return ProductDTO.builder()
                        .id(savedProduct.getId())
                        .image(savedProduct.getImage())
                        .name(savedProduct.getName())
                        .price(savedProduct.getPrice())
                        .category(new ProductDTO.CategoryDTO(savedProduct.getCategory()))
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
