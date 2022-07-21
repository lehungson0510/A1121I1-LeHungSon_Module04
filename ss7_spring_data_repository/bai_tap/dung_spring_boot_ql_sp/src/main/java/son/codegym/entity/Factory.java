package son.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "factory")
public class Factory {
    @Id
    @Column(name = "factory_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int factoryCode;
    private String name;

    @OneToMany(mappedBy = "factory", cascade = CascadeType.REMOVE)
    private Set<Product> products;

    public Factory() {
    }

    public Factory(int factoryCode, String name) {
        this.factoryCode = factoryCode;
        this.name = name;
    }

    public int getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(int factoryCode) {
        this.factoryCode = factoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
