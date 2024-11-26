package com.bagus.gen_24_java_servlet.service;

import com.bagus.gen_24_java_servlet.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void saveProducts(){
        products.add(new Product(1L, "Tahu", "Makanan", 5000.0, 50L));
        products.add(new Product(2L, "Tempe", "Makanan", 3000.0, 55L));
        products.add(new Product(3L, "Aqua", "Minuman", 2800.0, 100L));
        products.add(new Product(4L, "Golda Coffee", "Minuman", 3000.0, 80L));
        products.add(new Product(5L, "Bodrex", "Obat", 10000.0, 20L));
    }

    public List<Product> getProducts() {
        return products;
    }
}
