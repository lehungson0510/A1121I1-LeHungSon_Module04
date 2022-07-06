package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepoImpl;
import com.codegym.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements ICustomerService {

   // @Autowired
    private ICustomerRepo customerRepo = new CustomerRepoImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepo.update(id, customer);

    }

    @Override
    public void remove(int id) {
        customerRepo.remove(id);
    }
}
