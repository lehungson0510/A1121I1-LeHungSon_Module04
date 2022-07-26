package son.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select customer_id, name, email, address from customer where name like :nameCustomer", nativeQuery = true)
    Page<Product> search(@Param("nameCustomer") String name, Pageable pageable);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
