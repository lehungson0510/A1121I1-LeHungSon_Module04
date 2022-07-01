package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Product;
import son.codegym.repository.IProductRepository;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);

    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }
}
