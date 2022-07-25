package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Book;
import son.codegym.repository.IBookRepo;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    IBookRepo bookRepo;

    @Override
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void delete(String id) {
        bookRepo.deleteById(id);
    }

    @Override
    public void update(Book book) {
        bookRepo.save(book);
    }

    @Override
    public Book findById(String id) {
        return bookRepo.findById(id).orElse(null);
    }
}
