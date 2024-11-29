package com.bagus.gen_24_java_springboot_pos.entity.category;

import org.springframework.data.jpa.domain.Specification;

public class CategorySpecifications {
    public static Specification<Category> hasName(String name) {
        return (root, query, criteriaBuilder) ->
          name == null ? null : criteriaBuilder.equal(root.get("name"), name);
    }
}
