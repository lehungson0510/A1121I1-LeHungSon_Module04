package son.codegym.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Customer;

@Repository
public interface ICustomerRepo extends PagingAndSortingRepository<Customer, Long> {
}
