package relations.oneTableTwoEntities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="employees")
public class Employee {
    public static final String GET_ALL = "getAll";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "email")
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Embedded
    private Name name;


    @Transient
    private String birthDateString;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDateString() {
        if (birthDate != null) {
            return birthDate.format(formatter);
        }
        return birthDateString;
    }

    public void setBirthDateString(String birthDateString) {
        if (birthDateString != null && !"".equals(birthDateString.trim())) {
            birthDate = LocalDate.parse(birthDateString, formatter);
        }
        this.birthDateString = birthDateString;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", name=" + name +
                ", birthDateString='" + birthDateString + '\'' +
                '}';
    }
}
