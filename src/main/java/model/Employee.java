package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Entity
@Table(name="employees")
//@IdClass(EmployeeId.class)
@NamedQueries({
        @NamedQuery(name = "getAll", query = "select e from Employee e"),
        @NamedQuery(name = "getByFirstName", query = "select e from Employee e where LOWER(e.firstName) like :firstName"),
        @NamedQuery(name = "getByLastName", query = "select e from Employee e where LOWER(e.lastName) like :lastName"),
        @NamedQuery(name = "getByEmail", query = "select e from Employee e where LOWER(e.email) like :email"),
        @NamedQuery(name = "getByBirthDateBetween", query = "select e from Employee e where birthDate between :from and :to")
})
public class Employee {
    public static final String GET_ALL = "getAll";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Transient      // gdy nie ma takiej kolumny, a potrzebujemy
    private String birthDateString;

    // do statycznych się nie czepia
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", birthDateString='" + getBirthDateString() + '\'' +
                '}';
    }
}
