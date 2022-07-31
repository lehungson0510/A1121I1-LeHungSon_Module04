package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Borrowing;

@Repository
public interface IBorrowingRepo extends JpaRepository<Borrowing, Integer> {
    Borrowing findByIdBorrow(String id);
}
