package son.codegym.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import son.codegym.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
    Page<Customer> findAllSearch(String name, String email, String typeId, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
    Customer findById(String id);
    Page<Customer> search(String name, String email, String customerTypeId, Pageable pageable);
}
