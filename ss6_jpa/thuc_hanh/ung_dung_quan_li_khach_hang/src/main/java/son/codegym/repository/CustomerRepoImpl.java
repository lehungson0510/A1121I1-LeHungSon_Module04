package son.codegym.repository;

import son.codegym.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImpl implements ICustomerRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
       String sql = "call insert_customer(:name, :email, :address)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("name", customer.getName());
        query.setParameter("email", customer.getEmail());
        query.setParameter("address", customer.getAddress());
        return query.executeUpdate() != 0;
    }
}
