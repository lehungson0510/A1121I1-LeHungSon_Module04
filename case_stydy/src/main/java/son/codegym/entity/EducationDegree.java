package son.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationDegreeId;
    private String educationDegreeName;

    @JsonBackReference
    @OneToMany(mappedBy = "educationDegreeId", cascade = CascadeType.REMOVE)
    private Set<Employee> employees;

    public EducationDegree(){};

    public EducationDegree(int educationDegreeId, String educationDegreeName) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
