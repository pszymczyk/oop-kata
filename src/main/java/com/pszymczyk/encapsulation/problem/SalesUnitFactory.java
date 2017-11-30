package com.pszymczyk.encapsulation.problem;

import java.util.List;

/**
 * @author pawel szymczyk
 */
class SalesUnitFactory {

    private final EmployeeRepository employeeRepository;

    public SalesUnitFactory(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public SalesUnit create() {
        List<Employee> employees = employeeRepository.findAllFromSalesUnit();

        return new SalesUnit(employees);
    }
}
