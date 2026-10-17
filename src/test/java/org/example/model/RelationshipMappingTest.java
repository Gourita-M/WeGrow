package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelationshipMappingTest {

    @Test
    void employeeShouldBeLinkedToItsDepartment() {
        Department department = new Department("Engineering", "Platform team");
        Employee employee = new Employee();

        employee.setDepartment(department);

        assertSame(department, employee.getDepartment());
        assertTrue(department.getEmployees().contains(employee));
    }
}
