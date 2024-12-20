package com.bagus.point_of_sales.controller.db.cart;

import com.bagus.point_of_sales.controller.db.transaction.TransactionDTO;
import com.bagus.point_of_sales.model.cart.Cart;
import com.bagus.point_of_sales.model.cart.CartProduct;
import com.bagus.point_of_sales.model.product.Product;
import com.bagus.point_of_sales.model.transaction.Transaction;
import com.bagus.point_of_sales.model.user.Role;
import com.bagus.point_of_sales.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private UserDTO user;
    private List<CartProductDTO> cartProducts;
    private Long totalPrice;

    @Data
    public static class UserDTO {
        private Long id;
        private String name;
        private Role role;

        public UserDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.role = user.getRole();
        }
    }

    @Data
    public static class CartProductDTO {
        private Long id;
        private Product product;
        private int quantity;
        private Long price;

        public CartProductDTO(CartProduct cartProduct) {
            this.id = cartProduct.getId();
            this.product = cartProduct.getProduct();
            this.quantity = cartProduct.getQuantity();
            this.price = cartProduct.getPrice();
        }
    }

    public CartDTO(Cart cart) {
        this.id = cart.getId();
        this.user = new CartDTO.UserDTO(cart.getUser());
        this.totalPrice = cart.getTotalPrice();
        this.cartProducts = cart.getCartProducts().stream()
                .map(CartDTO.CartProductDTO::new)
                .collect(Collectors.toList());
    }
}
