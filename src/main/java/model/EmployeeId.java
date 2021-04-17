package model;

import java.io.Serializable;

public class EmployeeId implements Serializable {
    private int employeeId;
    private String firstName;

    public EmployeeId(int employeeId, String firstName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
    }

    public EmployeeId() {
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "EmployeeId{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
