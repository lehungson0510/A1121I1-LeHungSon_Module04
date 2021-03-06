package son.codegym.entity;

import javax.persistence.*;

@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idBorrow;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Borrowing() {
    }

    public Borrowing(int id, int idBorrow, Book book) {
        this.id = id;
        this.idBorrow = idBorrow;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(int idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
