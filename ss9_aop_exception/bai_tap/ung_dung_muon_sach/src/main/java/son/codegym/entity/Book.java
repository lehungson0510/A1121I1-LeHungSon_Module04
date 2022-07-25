package son.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @Column(name = "book_id", columnDefinition = "varchar(20)")
    private String id;
    private String name;
    private int quantity;
    private String status;
    @OneToMany(mappedBy = "book",cascade = CascadeType.REMOVE)
    private Set<Borrowing> borrowings;

    public Book() {
    }

    public Book(String id, String name, int quantity, String status, Set<Borrowing> borrowings) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
        this.borrowings = borrowings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
