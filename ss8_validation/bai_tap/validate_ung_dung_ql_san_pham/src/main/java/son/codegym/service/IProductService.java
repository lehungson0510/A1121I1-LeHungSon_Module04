package son.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import son.codegym.entity.Product;

import java.util.List;

public interface IProductService {
    void create(Product product);
    void update(Product product);
    void delete(String id);
    List<Product> findAll();
    Product findById(String id);
    Page<Product> findAllWithPaging(Pageable pageable);
    Page<Product> search(String name, Pageable pageable);

}
