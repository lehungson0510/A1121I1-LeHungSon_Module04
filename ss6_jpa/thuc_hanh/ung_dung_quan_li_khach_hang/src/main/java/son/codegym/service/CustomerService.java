package son.codegym.service;

import son.codegym.entity.Customer;
import son.codegym.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepo customerRepo;


    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void save(Customer customer) { customerRepo.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepo.delete(id);
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepo.search("%"+name + "%");
    }
}
