package codegym.vn.service;

import codegym.vn.entity.Customer;
import codegym.vn.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{
//    @Autowired
    private ICustomerRepo customerRepo;

    @Autowired
    public void setCustomerRepo(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void create(Customer customer) {
        customerRepo.create(customer);

    }

    @Override
    public void update(Customer customer) {
        customerRepo.update(customer);
    }

    @Override
    public void delete(String id) {
        customerRepo.delete(id);

    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(String id) {
        return customerRepo.findById(id);
    }
}
