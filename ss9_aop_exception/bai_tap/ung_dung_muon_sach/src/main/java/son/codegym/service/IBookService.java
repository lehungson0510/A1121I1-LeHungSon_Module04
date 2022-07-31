package son.codegym.service;

import son.codegym.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void add(Book book);
    void delete(String id);
    void update(Book book);
    Book findById(String id);
}
