package edus.controllers;


import edus.models.Product;
import edus.repositories.ProductRepository;
import edus.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.lang.Iterable;
import java.util.Map;
import java.util.UUID;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductsController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public Iterable<Product> getProducts(
            @RequestParam(name = "categoryLevel3Id", required = true) Integer categoryLevel3Id
    ) {
     return productService.getProductByCategoryLevel3Id(categoryLevel3Id);
    }

    @GetMapping("/findById")
    public Product findById(@RequestParam (name = "id", required = true) UUID id) {
       return productService.findById(id);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam (name = "id", required = true) UUID id) {
        productService.deleteById(id);
    }

    @GetMapping("/filter")
    public Iterable<Product> filterProductsByMultipleAttributes(
            @RequestParam(name = "categoryLevel3Id", required = true) Integer categoryLevel3Id,
            @RequestBody Map<String, String> attributeFilters
    ) {
        return productService.filterProductsByAttributes(categoryLevel3Id, attributeFilters);
    }
}
