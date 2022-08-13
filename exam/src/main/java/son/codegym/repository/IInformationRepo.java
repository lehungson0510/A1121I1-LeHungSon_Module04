package son.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Information;

@Repository
public interface IInformationRepo extends JpaRepository<Information, Integer> {

    @Query(value = "SELECT * FROM information where title like :title and category_id like:categoryId ",
            nativeQuery = true)
    Page<Information> findAndSearch(@Param("title") String title, @Param("categoryId") String category, Pageable pageable);
}

