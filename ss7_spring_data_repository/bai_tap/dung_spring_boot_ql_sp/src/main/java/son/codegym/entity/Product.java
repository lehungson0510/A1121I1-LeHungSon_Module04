package son.codegym.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", length = 20)
    private String id;
    private String name;
    private double price;
    private String description;
    private Date manufacturingDate;
    private Date outOfDate;

    @ManyToOne
    @JoinColumn(name = "factory_id")
    private Factory factory;

    public Product() {
    }

    public Product(String id, String name, double price, String description, Date manufacturingDate, Date outOfDate, Factory factory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturingDate = manufacturingDate;
        this.outOfDate = outOfDate;
        this.factory = factory;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getOutOfDate() {
        return outOfDate;
    }

    public void setOutOfDate(Date outOfDate) {
        this.outOfDate = outOfDate;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
