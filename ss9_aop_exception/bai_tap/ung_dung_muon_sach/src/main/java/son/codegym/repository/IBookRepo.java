package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Book;

@Repository
public interface IBookRepo extends JpaRepository<Book, String> {
}
