package vlaship.graphql.service;

import vlaship.graphql.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product find(String id);
    List<Product> findAll();
    List<Product> findAllByName(String name);

    Product update(String id, BigDecimal price);
    void delete(String id);
}
