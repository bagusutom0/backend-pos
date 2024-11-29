package com.bagus.gen_24_java_springboot_pos.entity.product;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null: criteriaBuilder.equal(root.get("name"), name);
    }

//    public static Specification<Product> hasPriceBeetween(int minPrice, int maxPrice) {
//        return (root, query, criteriaBuilder) ->
//                criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
//    }

    public static Specification<Product> hasStockMoreThanOrEqual(int stock){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("stock"), stock);
    }
}
