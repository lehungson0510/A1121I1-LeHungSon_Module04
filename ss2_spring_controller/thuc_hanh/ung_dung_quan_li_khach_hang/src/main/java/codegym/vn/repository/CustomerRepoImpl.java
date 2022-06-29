package codegym.vn.repository;

import codegym.vn.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepoImpl implements ICustomerRepo {

    private static Map<String, Customer> customerMap = new HashMap<>();
    static {
        customerMap.put("SV001", new Customer("SV001", "Nhi","a@gmail.com","Quảng Nam"));
        customerMap.put("SV002", new Customer("SV002", "Sơn","b@gmail.com","Huế"));
        customerMap.put("SV003", new Customer("SV003", "Thắng","c@gmail.com","HCM"));
        customerMap.put("SV004", new Customer("SV004", "Huy","d@gmail.com","Nha Trang"));
        customerMap.put("SV005", new Customer("SV005", "Trường","e@gmail.com","Quảng Bình"));
    }
    @Override
    public void create(Customer customer) {
        customerMap.put(customer.getId(),customer);
    }

    @Override
    public void update(Customer student) {

    }

    @Override
    public void delete(String id) {
        customerMap.remove(id);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer findById(String id) {
        return customerMap.get(id);
    }
}
