package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.codegym.entity.AppUser;
import son.codegym.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public interface IUserRoleRepo extends JpaRepository<UserRole, Long> {
 List<UserRole> findByAppUser(AppUser appUser);

}
