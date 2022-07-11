package son.codegym.repository;

import son.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    boolean insertWithStoredProcedure(Customer customer);
}
