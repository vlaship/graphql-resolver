package vlaship.graphql.repository;

import vlaship.graphql.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{ 'nameProduct': { $regex: ?0, $options: 'i' } }")
    List<Product> findAllByProductName(String name);
}
