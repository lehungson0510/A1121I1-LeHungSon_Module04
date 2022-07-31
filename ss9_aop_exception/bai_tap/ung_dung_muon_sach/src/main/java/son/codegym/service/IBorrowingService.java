package son.codegym.service;

import son.codegym.entity.Borrowing;

import java.util.List;

public interface IBorrowingService {
    List<Borrowing> findAll();
    void add(Borrowing borrowing, String idBook);
    void delete(String id);
    void update(Borrowing borrowing);
    Borrowing findByIdBorrow(String id);

}
