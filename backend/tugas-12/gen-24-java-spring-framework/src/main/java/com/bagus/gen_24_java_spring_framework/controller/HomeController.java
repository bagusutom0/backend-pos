package com.bagus.gen_24_java_spring_framework.controller;

import com.bagus.gen_24_java_spring_framework.entity.Product;
import com.bagus.gen_24_java_spring_framework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService service;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "index";
    }

    @GetMapping("/save")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "save";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
        Optional<Product> product = service.findById(id);
        System.out.println("product: " + product);
        if (product.isPresent()) {
            model.addAttribute("product", product);
            return "update";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product) {
        service.saveProducts(product);
        return "redirect:/";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product) {
        service.saveProducts(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return "redirect:/";
    }
}
