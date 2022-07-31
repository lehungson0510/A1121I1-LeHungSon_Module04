package son.codegym.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.SmartPhone;

@Repository
public interface ISmartPhoneRepo extends JpaRepository<SmartPhone, Long> {
}
