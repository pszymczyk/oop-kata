package com.pszymczyk.encapsulation.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * class name inspired by https://www.youtube.com/watch?v=1aEqd4bl6Bs&t=7s
 *
 * @author pawel szymczyk
 */
class MexicanInternProgrammerSalesUnitFactory {

    private final EmployeeRepository employeeRepository;

    private List<Employee> employees = new ArrayList<>();

    public MexicanInternProgrammerSalesUnitFactory(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public SalesUnit create() {
        this.employees = employeeRepository.findAllFromSalesUnit();

        return new SalesUnit(employees);
    }

    /**
     * encapsulation breaks :(
     */
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
