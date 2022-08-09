package son.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, String> {
//     Page<Customer> findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeId(String name, String email, int customerTypeId, Pageable pageable);

     //     @Query(value = "select * from question where title like %?1% and id_question_type =?2", nativeQuery = true)
//     List<Question> searchBy(String search, String type);
     @Query(value="select * from customer where customer_name like %?1% and customer_email like %?2% and customer_type_id =?3", nativeQuery = true)
     Page<Customer> search(String name, String email, int id, Pageable pageable);

//     Page<Customer> findAllByCustomerTypeId_CustomerNameContains(String name);
}
