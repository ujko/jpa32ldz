package relations.manyToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sekwencje")
    @Column(name = "dev_id")
    private int devId;

    @Column(name = "dev_name")
    private String devName;

    @ManyToMany
    private Set<Project> set = new HashSet<>();

    public void addProject(Project project) {
        set.add(project);
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public Set<Project> getSet() {
        return set;
    }

    public void setSet(Set<Project> set) {
        this.set = set;
    }
}
