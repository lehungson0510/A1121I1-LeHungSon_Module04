package son.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, String> {
     Page<Customer> findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeIdOrderByCustomerEmail(String name, String email, int customerTypeId, Pageable pageable);
     Page<Customer> findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeNameContainingOrderByCustomerEmail(String name, String email, String customerTypeId, Pageable pageable);
//
//     @Query(value="SELECT * FROM product where `name` like :nameSearch and price like:priceSearch and category_id like :categoryId",
//             countQuery ="SELECT * FROM product where `name` like :nameSearch  and price like:priceSearch and category_id like :categoryId",nativeQuery = true)
//     Page<Product> search(@Param("nameSearch")String nameSearch, @Param("priceSearch") String priceSearch, @Param("categoryId") String categoryIdSearch, Pageable pageable);

     @Query(value="SELECT * FROM customer where customer_name like :nameSearch and customer_email like:emailSearch and customer_type_id like :customerTypeId",
             nativeQuery = true)
     Page<Customer> search(@Param("nameSearch")String nameSearch, @Param("emailSearch") String emailSearch, @Param("customerTypeId") String customerTypeId, Pageable pageable);
}
