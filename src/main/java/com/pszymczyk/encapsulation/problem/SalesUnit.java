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
        return employees.stream()
                .filter(e -> e.getId() == employeeId)
                .findFirst()
                .map(e -> e.getBoss())
                .orElseThrow(() -> new RuntimeException("Cannot fid empoyee for given id"));
    }
}
