package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.codegym.entity.Music;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music, String> {

}
