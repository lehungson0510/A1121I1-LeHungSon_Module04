package son.codegym.service.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import son.codegym.entity.Information;

public interface IInformationService {
    void create(Information information);
    void delete(int id);
    Page<Information> findAllSearch(String title, String category, Pageable pageable);
    Page<Information> findAll(Pageable pageable);
    Information findById(int id);
    Page<Information> search(String title, String category, Pageable pageable);
}
