package com.buymore.buymore.employee;


import com.buymore.buymore.department.Department;
import com.buymore.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends User {

    private String employeeFirstName;
    private String employeeLastName;
    private String employeePhoneNumber;
    @Column(unique = true)
    private String employeeEmail;
    private String employeeAddress;
    private String employeePosition;
    private double employeeSalary;
    @ManyToMany
    private List< Department> departmentsWorkedInStore;

    public Employee(String userName, String password, String systemRole, String employeeFirstName, String employeeLastName, String employeePhoneNumber, String employeeEmail, String employeeAddress, String employeePosition, double employeeSalary) {
        super(userName, password, systemRole);
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
        this.departmentsWorkedInStore = new ArrayList<>();
    }


    public Employee() {
        this.departmentsWorkedInStore = new ArrayList<>();
    }

    public List<Department> getDepartmentsWorkedInStore() {
        return departmentsWorkedInStore;
    }

    public void setDepartmentsWorkedInStore(List<Department> departmentsWorkedInStore) {
        this.departmentsWorkedInStore = departmentsWorkedInStore;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", departmentsWorkedInStore=" + departmentsWorkedInStore +
                "} " + super.toString();
    }
}
