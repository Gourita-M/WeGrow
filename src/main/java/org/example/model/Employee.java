package org.example.model;

import java.util.UUID;

public class Employee {
    private long id;
    private UUID employeeNumber;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private ContractType contract;

    public Employee(){

    }

    public Employee(long id, UUID employeeNumber, String firstName, String lastName, String jobTitle, ContractType contract) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.contract = contract;
    }

    public enum ContractType{
        CDI,
        CDD,
        InternShip
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(UUID employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ContractType getContract() {
        return contract;
    }

    public void setContract(ContractType contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeNumber=" + employeeNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", contract=" + contract +
                '}';
    }
}

