package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
}
