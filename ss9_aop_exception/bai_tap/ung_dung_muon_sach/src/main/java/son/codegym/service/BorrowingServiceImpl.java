package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Book;
import son.codegym.entity.Borrowing;
import son.codegym.repository.IBookRepo;
import son.codegym.repository.IBorrowingRepo;

import java.util.List;
import java.util.Random;

@Service
public class BorrowingServiceImpl implements IBorrowingService {
    @Autowired
    IBorrowingRepo borrowingRepo;

    @Autowired
    IBookRepo bookRepo;

    @Autowired
    IBookService bookService;

    @Override
    public List<Borrowing> findAll() {
        return borrowingRepo.findAll();
    }

    @Override
    public void add(Borrowing borrowing, String idBook) {
        // nextInt random từ 0 đến 89999
        borrowing.setIdBorrow((new Random().nextInt(90000) + 10000) + "");
        Book book = bookService.findById(idBook);
        book.setQuantity(book.getQuantity() - 1);
        borrowing.setBook(book);
        borrowingRepo.save(borrowing);

    }

    @Override
    public void delete(String idBorrowing) {
        Borrowing borrowing = findByIdBorrow(idBorrowing);
        Book book = bookService.findById(borrowing.getBook().getId());
        book.setQuantity(book.getQuantity()+1);
        borrowingRepo.delete(borrowing);
    }

    @Override
    public void update(Borrowing borrowing) {
        borrowingRepo.save(borrowing);
    }

    @Override
    public Borrowing findByIdBorrow(String id) {
        return borrowingRepo.findByIdBorrow(id);
    }
}
