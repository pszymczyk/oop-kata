package com.pszymczyk.encapsulation.problem;

import java.util.Collections;
import java.util.List;

/**
 * @author pawel szymczyk
 */
class SalesUnit {

    private final List<Employee> employees;

    public SalesUnit(List<Employee> employees) {
        this.employees = Collections.unmodifiableList(employees);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee findBoss(int employeeId) {
        for (Employee employee: employees) {
            if (employee.getId() == employeeId) {
                return employee.getBoss();
            }
        }

        throw new RuntimeException("Cannot find employee for given id");
    }
}
