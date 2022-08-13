package son.codegym.service.information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Category;
import son.codegym.repository.ICategory;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategory category;

    @Override
    public List<Category> findAll() {
        return category.findAll();
    }
}
