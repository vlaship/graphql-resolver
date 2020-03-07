package vlaship.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import vlaship.graphql.model.Product;
import vlaship.graphql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import org.reactivestreams.Publisher;

@RequiredArgsConstructor
@Component
public class ProductSubscriptions implements GraphQLSubscriptionResolver {

    private final ProductService productService;

    public Publisher<Product> product() {
        return null;
    }

}
