package com.bagus.gen_24_java_springboot_pos.service;

import com.bagus.gen_24_java_springboot_pos.entity.category.Category;
import com.bagus.gen_24_java_springboot_pos.entity.category.CategoryRepository;
import com.bagus.gen_24_java_springboot_pos.entity.product.Product;
import com.bagus.gen_24_java_springboot_pos.entity.product.ProductRepository;
import com.bagus.gen_24_java_springboot_pos.entity.product.ProductSpecifications;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> filterProduct(String name /*, int minPrice, int maxPrice  */ , int stock) {
        Specification<Product> spec = Specification
                .where(ProductSpecifications.hasName(name))
                .and(ProductSpecifications.hasStockMoreThanOrEqual(stock));

        return productRepository.findAll(spec);
    }

    public List<Product> getAllProductNative() {
        return productRepository.findAllProductNative();
    }

    public List<Product> getAllProductJpql() {
        return productRepository.findAllProductJpql();
    }

    public Product createProduct(
            Long category_id,
            String name,
            int stock,
            int price
    ) {
        Category category = categoryRepository.findById(category_id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        Product product = new Product();
        product.setPrice(price);
        product.setName(name);
        product.setCategory(category);
        product.setStock(stock);
        return productRepository.save(product);
    }

    public Product updateProduct(
                Long transaction_id,
                Long category_id,
                String name,
                int stock,
                int price
            ) {
        return productRepository.findById(transaction_id)
                .map(product -> {
                    Category category = categoryRepository.findById(category_id)
                            .orElseThrow(() -> new EntityNotFoundException("Category not found"));

                    product.setCategory(category);
                    product.setName(name);
                    product.setStock(stock);
                    product.setPrice(price);

                    return productRepository.save(product);
                })
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
