package com.bagus.point_of_sales.controller.db.product;


import com.bagus.point_of_sales.model.product.Category;
import com.bagus.point_of_sales.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String image;
    private Long price;
    private CategoryDTO category;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryDTO {
        private Long id;
        private String name;
        private Long totalRelatedProducts;

        public CategoryDTO(Category category) {
            this.id = category.getId();
            this.name = category.getName();
            this.totalRelatedProducts = (long) category.getProducts().size();
        }
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.image = product.getImage();
        this.category = new CategoryDTO(product.getCategory());
    }
}
