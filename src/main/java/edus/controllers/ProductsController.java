package edus.controllers;


import edus.models.Product;
import edus.repositories.ProductRepository;
import edus.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.lang.Iterable;

@RestController
@RequestMapping("/api")
public class ProductsController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductsController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public Iterable<Product> getProducts(
            @RequestParam(name = "categoryLevel3Id", required = true) Integer categoryLevel3Id
    ) {
        System.out.println("Received categoryLevel3Id: " + categoryLevel3Id);
        return productService.getProductByCategoryLevel3Id(categoryLevel3Id);
    }
}
