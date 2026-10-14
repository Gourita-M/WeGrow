package org.example.model;

public class Departement {
    private long id;
    private String name;
    private String description;
    private long employeeCount;

    public Departement(){

    }

    public Departement(long id, String name, String description, long employeeCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.employeeCount = employeeCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
