package dao;

import model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeDao {
    List<Employee> getAllEmployees();
    Employee getById(int id);
    List<Employee> getByFirstName(String firstName);
    List<Employee> getByLastName(String lastName);
    List<Employee> getEmail(String email);
    List<Employee> getByBirthDateBetween(LocalDate from, LocalDate to);
    int addEmployee(Employee employee);
    boolean deleteEmployee(int id);
    boolean updateEmployee(Employee employee);

}
