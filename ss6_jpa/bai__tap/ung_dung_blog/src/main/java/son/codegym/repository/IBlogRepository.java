package son.codegym.repository;

import son.codegym.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByNameContaining(String name);
}
