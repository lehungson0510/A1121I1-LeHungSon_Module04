package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.codegym.entity.CustomerType;

public interface ICustomerTypeRepo extends JpaRepository<CustomerType, Integer> {
}
