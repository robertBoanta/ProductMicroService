package edus.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import edus.models.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.lang.Iterable;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT * FROM edus_products WHERE category_level_3_id = :categoryLevel3Id AND category_level_3_id IS NOT NULL")
    Iterable<Product> getProductByCategoryLevel3Id(@Param("categoryLevel3Id") Integer categoryLevel3Id);
}
