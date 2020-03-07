package vlaship.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import vlaship.graphql.model.Product;
import vlaship.graphql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductQueries implements GraphQLQueryResolver {

    private final ProductService productService;

    public List<Product> products() {
        return productService.findAll();
    }

    public List<Product> productsByName(String name) {
        return productService.findAllByName(name);
    }

    public Product product(String id) {
        return productService.find(id);
    }

}