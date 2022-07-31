package son.codegym.controller.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import son.codegym.entity.Blog;
import son.codegym.entity.Category;
import son.codegym.service.IBlogService;
import son.codegym.service.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAllCategories(@PageableDefault(value = 5) Pageable pageable) {
        List<Category> categoryList = categoryService.findAll();
        if(categoryList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(categoryList,HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Page<Blog>> viewCategory(@PathVariable("id") int id, Pageable pageable) {
        Category category = categoryService.findById(id);
        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            Page<Blog> blogList = blogService.findAllByCategory(id,pageable);
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }

    }
}
