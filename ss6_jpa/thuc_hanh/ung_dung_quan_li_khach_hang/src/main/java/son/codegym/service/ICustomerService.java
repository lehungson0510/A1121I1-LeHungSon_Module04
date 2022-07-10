package son.codegym.service;

import son.codegym.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(int id);

    List<Customer> search(String name);
}

