package com.bagus.point_of_sales.controller.db.cart;

import com.bagus.point_of_sales.controller.db.cart.request.*;
import com.bagus.point_of_sales.service.db.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService service;

//    @GetMapping("/open")
//    public ResponseEntity<CartDTO> openCart(@RequestHeader(name = "Authorization") String authHeader) {
//        return ResponseEntity.ok(service.openCart(authHeader));
//    }

    @GetMapping("/products")
    public ResponseEntity<CartDTO> getCartProducts(@RequestBody CartProductRequest request) {
        return ResponseEntity.ok(service.getCart(request));
    }

//    @Secured("ROLE_CASHIER")
//    @PostMapping("/add")
//    public ResponseEntity<CartDTO> addCartProduct(@RequestBody AddProductRequest request) {
//        return ResponseEntity.ok(service.addProductToCart(request));
//    }

    @PutMapping("/update")
    public ResponseEntity<CartDTO> updateCart(@RequestBody UpdateProductRequest request) {
        return ResponseEntity.ok(service.updateProduct(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CartDTO> deleteCart(@RequestBody DeleteProductRequest request) {
        return ResponseEntity.ok(service.deleteProduct(request));
    }

//    @Secured("ROLE_CASHIER")
//    @PostMapping("/checkout")
//    public ResponseEntity<CartDTO> checkout(@RequestBody CheckoutRequest request) {
//        return ResponseEntity.ok(service.checkout(request));
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleContentNotAllowedException(IllegalArgumentException illegalArgumentException) {
        String errors = illegalArgumentException.getMessage();

        return new ResponseEntity<>(new ApiError(errors), HttpStatus.BAD_REQUEST);
    }
}
