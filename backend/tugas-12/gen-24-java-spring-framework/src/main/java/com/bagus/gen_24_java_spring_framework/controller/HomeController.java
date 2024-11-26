package com.bagus.gen_24_java_spring_framework.controller;

import com.bagus.gen_24_java_spring_framework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService service;

    @GetMapping
    public String home(Model model) {
        service.saveProducts();
        model.addAttribute("products", service.getAllProducts());
        return "index";
    }
}
