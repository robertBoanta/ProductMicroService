package edus.services;

import edus.models.Product;
import edus.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProductByCategoryLevel3Id(Integer categoryLevel3Id) {
        return productRepository.getProductByCategoryLevel3Id(categoryLevel3Id);
    }

    public Product findById(UUID id) {
        return productRepository.findById(id);
    }
}
