package com.bagus.merchant_paymentgateway.service;

import com.bagus.merchant_paymentgateway.controller.CustomerRequest;
import com.bagus.merchant_paymentgateway.entity.Customer;
import com.bagus.merchant_paymentgateway.entity.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final CustomerRepository repository;

    public Customer insertCustomer(CustomerRequest request) {
        Customer customer = Customer.builder()
                .name(request.getName())
                .build();
        return repository.save(customer);
    }
}
