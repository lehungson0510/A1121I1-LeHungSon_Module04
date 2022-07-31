package son.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @Column(name = "book_id", columnDefinition = "varchar(20)")
    private String id;
    private String name;
    @Column(columnDefinition = "integer default '2' ")
    private int quantity;
    @Column(columnDefinition = "boolean default false")
    private boolean status;
    @OneToMany(mappedBy = "book",cascade = CascadeType.REMOVE)
    private Set<Borrowing> borrowings;

    public Book() {
    }

    public Book(String id, String name, int quantity, boolean status, Set<Borrowing> borrowings) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
