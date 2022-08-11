package son.codegym.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import son.codegym.entity.Customer;
import son.codegym.repository.ICustomerRepo;
import sun.security.krb5.internal.PAData;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  ICustomerService{
    @Autowired
    ICustomerRepo customerRepo;

    @Override
    public void create(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> findAllSearch(String name, String email, String typeId,Pageable pageable) {
        return customerRepo.search("%"+name+"%","%"+email+"%","%"+typeId+"%", pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> search(String name, String email, String customerTypeId, Pageable pageable) {
        return customerRepo.search(name,email,customerTypeId,pageable);
    }


}
