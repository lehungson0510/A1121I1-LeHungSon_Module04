package son.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.REMOVE)
    private Set<Information> information;

    public Category() {
    }

    public Category(int id, String name, Set<Information> information) {
        this.id = id;
        this.name = name;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Information> getInformation() {
        return information;
    }

    public void setInformation(Set<Information> information) {
        this.information = information;
    }
}
