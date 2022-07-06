package com.codegym.repository;

import com.codegym.model.Customer;
import com.sun.org.apache.xalan.internal.xsltc.dom.CurrentNodeListFilter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepoImpl implements ICustomerRepo {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = entityManager
                .createQuery("select c from Customer c")
                .getResultList();
        // Native SQL
//        students = entityManager
//                .createNativeQuery("select * from Student")
//                .getResultList();
        return customerList;
    }

    @Modifying
    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Modifying
    @Override
    public void update(int id, Customer customer) {
        entityManager.merge(customer);
    }

    @Modifying
    @Override
    public void remove(int id) {
        entityManager.remove(id);
    }
}
