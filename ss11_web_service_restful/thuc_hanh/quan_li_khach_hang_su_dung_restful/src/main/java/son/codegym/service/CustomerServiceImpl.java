package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Customer;
import son.codegym.repository.ICustomerRepo;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    ICustomerRepo customerRepo;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.deleteById(id);
    }
}
