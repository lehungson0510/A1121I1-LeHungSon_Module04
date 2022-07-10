package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICustomerRepo extends JpaRepository<Customer, Integer > {

    @Query(value = "from Customer where name like :nameCustomer", nativeQuery = false)
    List<Customer> search(@Param("nameCustomer") String name);

    @Modifying // để ở các phương thức làm thay đổi DB
    @Query(value = "delete from Customer where id = :id", nativeQuery = false)
    void delete(@Param("id") int id);
}
