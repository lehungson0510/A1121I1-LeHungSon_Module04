package son.codegym.service;

import son.codegym.model.Customer;
import son.codegym.repository.CustomerRepoImpl;
import son.codegym.repository.ICustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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
