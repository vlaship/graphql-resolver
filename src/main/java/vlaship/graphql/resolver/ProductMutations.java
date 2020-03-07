package vlaship.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import vlaship.graphql.model.Product;
import vlaship.graphql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductMutations implements GraphQLMutationResolver {

    private final ProductService productService;

    public Product updateProduct(String id, BigDecimal price) {
        return productService.update(id, price);
    }

    public void deleteProduct(String id) {
        productService.delete(id);
    }

}
