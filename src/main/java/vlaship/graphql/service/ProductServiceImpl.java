package vlaship.graphql.service;

import vlaship.graphql.ProductNotFoundException;
import vlaship.graphql.model.Product;
import vlaship.graphql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product find(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByName(String name) {
        return productRepository.findAllByProductName(name);
    }

    @Override
    public Product update(String id, BigDecimal price) {
        return productRepository.save(find(id).setPrice(price));
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
