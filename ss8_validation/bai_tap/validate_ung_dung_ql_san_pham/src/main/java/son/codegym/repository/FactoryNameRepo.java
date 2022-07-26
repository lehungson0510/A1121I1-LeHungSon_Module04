package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Factory;

@Repository
public interface FactoryNameRepo extends JpaRepository<Factory, Integer> {

}
