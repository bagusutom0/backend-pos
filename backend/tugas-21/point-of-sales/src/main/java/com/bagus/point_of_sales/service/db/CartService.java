package com.bagus.point_of_sales.service.db;

import com.bagus.point_of_sales.controller.db.cart.CartDTO;
import com.bagus.point_of_sales.controller.db.cart.request.*;
import com.bagus.point_of_sales.model.cart.Cart;
import com.bagus.point_of_sales.model.cart.CartProduct;
import com.bagus.point_of_sales.model.cart.CartRepository;
import com.bagus.point_of_sales.model.user.User;
import com.bagus.point_of_sales.model.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
//    private final CartProductRepository cartProductRepository;
//    private final ProductRepository productRepository;
    private final UserRepository userRepository;
//    private final TransactionRepository transactionRepository;
//    private final TransactionProductRepository transactionProductRepository;
//    private final PGWRepository pgwRepository;

//    public CartDTO openCart(String authHeader) {
//        String token = authHeader.substring(7);
//        Optional<User> userOpt = userRepository.findByUsername(username);
//
//        if (userOpt.isPresent()) {
//            User user = userOpt.get();
//
//            Cart cart = new Cart();
//            cart.setCartProducts(List.of());
//            cart.setTotalPrice(0L);
//            cart.setUser(user);
//            Cart savedCart = cartRepository.save(cart);
//            return CartDTO.builder()
//                    .id(savedCart.getId())
//                    .cartProducts(Collections.emptyList())
//                    .totalPrice(0L)
//                    .user(new CartDTO.UserDTO(user))
//                    .build();
//        } else {
//            throw new EntityNotFoundException("User not found");
//        }
//    }

//    public CartDTO addProductToCart(AddProductRequest request) {
//        Cart cart = cartRepository.findById(request.getCartId())
//                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));
//
//        Product product = productRepository.findById(request.getProductId())
//                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
//
//        if (product.getStock() < request.getQuantity()) {
//            throw new IllegalArgumentException("Invalid stock");
//        } else {
//            Long totalProductPrice = product.getPrice() * request.getQuantity();
//            product.setStock(product.getStock() - request.getQuantity());
//
//            CartProduct cartProduct = CartProduct.builder()
//                    .cart(cart)
//                    .product(product)
//                    .quantity(request.getQuantity())
//                    .price(totalProductPrice)
//                    .build();
//
//            cartProductRepository.save(cartProduct);
//            cart.getCartProducts().add(cartProduct);
//            cart.setTotalPrice(cart.getTotalPrice() + totalProductPrice);
//            Cart savedCart = cartRepository.save(cart);
//
//            return new CartDTO(savedCart);
//        }
//    }

    public CartDTO getCart(CartProductRequest request) {
        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));

        return new CartDTO(cart);
    }

    public CartDTO updateProduct(UpdateProductRequest request) {
        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));

        CartProduct cartProduct = cart.getCartProducts().stream()
                .filter(cp -> cp.getId().equals(request.getCartProductId()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Cart Product not found"));

        if (request.getQuantity() > 0) {
            cartProduct.setQuantity(request.getQuantity());
            cartProduct.setPrice(cartProduct.getProduct().getPrice() * request.getQuantity());
        } else {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        Long totalPrice = cart.getCartProducts().stream()
                .mapToLong(CartProduct::getPrice)
                .sum();
        cart.setTotalPrice(totalPrice);

        Cart savedCart = cartRepository.save(cart);

        List<CartDTO.CartProductDTO> cartProductDTOList = cart.getCartProducts().stream()
                .map(CartDTO.CartProductDTO::new)
                .toList();

        return CartDTO.builder()
                .id(savedCart.getId())
                .user(new CartDTO.UserDTO(savedCart.getUser()))
                .cartProducts(cartProductDTOList)
                .totalPrice(savedCart.getTotalPrice())
                .build();
    }

    public CartDTO deleteProduct(DeleteProductRequest request) {
        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));

        CartProduct cartProduct = cart.getCartProducts().stream()
                .filter(cp -> cp.getId().equals(request.getCartProductId()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Cart Product not found"));

        cart.setTotalPrice(cart.getTotalPrice() - cartProduct.getPrice());
        cart.getCartProducts().remove(cartProduct);
        Cart savedCart = cartRepository.save(cart);

        return new CartDTO(savedCart);
    }

//    public CartDTO checkout(CheckoutRequest request) {
//        try {
//            PaymentMethod paymentMethod = PaymentMethod.valueOf(request.getPaymentMethod());
//
//            Cart cart = cartRepository.findById(request.getCartId())
//                    .orElseThrow(() -> new EntityNotFoundException("Cart not found"));
//
//            Transaction transaction = new Transaction();
//            transaction.setUser(cart.getUser());
//            transaction.setTotalAmount(cart.getTotalPrice());
//            transaction.setPaymentMethod(PaymentMethod.valueOf(request.getPaymentMethod()));
//            transaction.setCreatedAt(LocalDateTime.now());
//
//            if (paymentMethod.name().equals(PaymentMethod.CASH.name())) {
//                transaction.setIsPaid(true);
//                transaction.setPaymentDate(LocalDateTime.now());
//                List<TransactionProduct> transactionProducts = cart.getCartProducts().stream()
//                        .map(cartProduct -> TransactionProduct.builder()
//                                .transaction(transaction)
//                                .product(cartProduct.getProduct())
//                                .quantity(cartProduct.getQuantity())
//                                .subtotal(cartProduct.getPrice())
//                                .build())
//                        .toList();
//                transaction.setTransactionProducts(transactionProducts);
//                transactionRepository.save(transaction);
//            } else {
//                PGW pgw = pgwRepository.findByMethod(paymentMethod)
//                        .orElseThrow(() -> new EntityNotFoundException(
//                                "Payment Gateway with method " + paymentMethod + " not found"
//                        ));
//
//                transaction.setIsPaid(false);
//                transaction.setPaymentDate(null);
//                List<TransactionProduct> transactionProducts = cart.getCartProducts().stream()
//                        .map(cartProduct -> TransactionProduct.builder()
//                                .transaction(transaction)
//                                .product(cartProduct.getProduct())
//                                .quantity(cartProduct.getQuantity())
//                                .subtotal(cartProduct.getPrice())
//                                .build())
//                        .toList();
//                transaction.setTransactionProducts(transactionProducts);
//                // buat va number
//                String unicode = pgw.getUcode();
//                String vaNumber = unicode + cart.getUser().getId(); // dengan kode bank
//                transaction.setVaNumber(vaNumber);
//
//                Transaction savedTransaction = transactionRepository.save(transaction); // error
//
//                // panggil payment gateway
//                String url = "http://localhost:8081/propay/api/v1/va/add";
//                WebClient.Builder webClientBuilder = WebClient.builder();
//                VaRequest vaRequest = new VaRequest();
//                vaRequest.setVaNumber(vaNumber);
//                vaRequest.setAmount(savedTransaction.getTotalAmount());
//                vaRequest.setToken(pgw.getToken());
//                vaRequest.setPaymentCallbackUri("http://localhost:8080/api/v1/transaction/payment");
//
//                webClientBuilder.build()
//                        .post()
//                        .uri(url)
//                        .bodyValue(vaRequest)
//                        .retrieve()
//                        .toBodilessEntity()
//                        .doOnSuccess(response -> System.out.println("Insert Virtual Account successfull"))
//                        .doOnError(error -> System.err.println("Failed to insert Virtual Account: " + error.getMessage()))
//                        .subscribe();
//            }
//
//            cart.getCartProducts().clear();
//            cart.setTotalPrice(0L);
//            Cart savedCart = cartRepository.save(cart);
//
//            return new CartDTO(savedCart);
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//            throw new IllegalArgumentException("Invalid payment method: " + request.getPaymentMethod());
//        }
//    }
}