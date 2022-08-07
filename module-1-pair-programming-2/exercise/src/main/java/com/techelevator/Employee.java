package com.techelevator;

public class Employee {

    private long employeeId;
    private String firstName;
    private String lastName;
    private String eMail;
    private double salary;
    private Department department;
    private String hireDate;
    private final double STARTING_SALARY = 60000;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    static double startingSalary = 60000;

    public Employee(long employeeId, String firstName, String lastName, String eMail, Department department, String hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.department = department;
        this.hireDate = hireDate;
        this.salary = startingSalary;
    }

    public Employee() {
    }

    public String getFullName() {
        return getLastName() + ", " + getFirstName();
    }

    public void raiseSalary(double percent) {
        salary += salary / 100 * percent;
    }
}
