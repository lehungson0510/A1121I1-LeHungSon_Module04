package codegym.vn.service;

import codegym.vn.entity.Customer;

import java.util.List;

public interface ICustomerService {
    void create(Customer student);
    void update(Customer student);
    void delete(String id);
    List<Customer> findAll();
    Customer findById(String id);
}
