package son.codegym.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId;
    @Size(max = 50,message = "Không quá 50 kí tự")
    @NotBlank(message = "Không được để trống")
    private String title;
    @Size(max = 500,message = "Không quá 500 kí tự")
    @NotBlank(message = "Không được để trống")
    private String content;
    private Date date;
    @NotBlank(message = "Không được để trống")
    private String reporter;

    public Information() {
    }

    public Information(int id, Category categoryId, String title, String content, Date date, String reporter) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.date = date;
        this.reporter = reporter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
}
