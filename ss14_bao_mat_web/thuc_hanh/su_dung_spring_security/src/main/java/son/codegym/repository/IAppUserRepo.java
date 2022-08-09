package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.codegym.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
@Transactional
public interface IAppUserRepo extends JpaRepository<AppUser,Long > {
        AppUser findByUserName(String userName);


}
