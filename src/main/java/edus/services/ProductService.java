package edus.services;

import edus.models.Product;
import edus.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    // In ProductService
    public Iterable<Product> filterProductsByAttributes(Integer categoryLevel3Id, Map<String, String> filters) {
        Iterable<Product> products = getProductByCategoryLevel3Id(categoryLevel3Id);

        if (filters == null || filters.isEmpty()) {
            return products;
        }

        return StreamSupport.stream(products.spliterator(), false)
                .filter(product -> matchesAttributeFilters(product, filters))
                .collect(Collectors.toList());
    }

    private boolean matchesAttributeFilters(Product product, Map<String, String> filters) {
        List<Product.Attribute> attributes = product.getAttributes();

        return filters.entrySet().stream().allMatch(filter ->
                attributes.stream().anyMatch(attr ->
                        filter.getKey().equalsIgnoreCase(attr.getAttributeName()) &&
                                filter.getValue().equalsIgnoreCase(attr.getAttributeValue())
                )
        );
    }

}
