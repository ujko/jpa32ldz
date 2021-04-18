package relations.manyToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sekwencje")
    @Column(name = "project_id")
    private int projId;

    @Column(name = "proj_name")
    private String projName;

    @ManyToMany
    private Set<Developer> set = new HashSet<>();

    public void addDev(Developer developer) {
        set.add(developer);
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public Set<Developer> getSet() {
        return set;
    }

    public void setSet(Set<Developer> set) {
        this.set = set;
    }
}
