package com.bagus.gen_24_java_servlet.controller;

import com.bagus.gen_24_java_servlet.service.ProductService;
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
        model.addAttribute("products", service.getProducts());
        return "index";
    }
}
