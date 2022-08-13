package son.codegym.service.information;

import son.codegym.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
