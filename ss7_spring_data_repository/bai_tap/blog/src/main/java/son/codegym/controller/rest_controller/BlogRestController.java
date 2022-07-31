package son.codegym.controller.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import son.codegym.entity.Blog;
import son.codegym.service.IBlogService;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> findAllBlogs(@PageableDefault(sort = {"id"},direction = Sort.Direction.ASC,value = 5) Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        if(blogList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if(blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(blog,HttpStatus.OK);
        }
    }
}
