package son.codegym.service;

import son.codegym.entity.Customer;

import java.util.Optional;

public interface ICustomerService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    Customer save(Customer customer);

    void remove(Long id);
}
