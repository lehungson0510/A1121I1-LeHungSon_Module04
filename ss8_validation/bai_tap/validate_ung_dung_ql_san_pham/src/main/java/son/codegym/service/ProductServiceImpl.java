package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import son.codegym.entity.Product;
import son.codegym.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findAllWithPaging(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> search(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name,pageable);
    }
}
