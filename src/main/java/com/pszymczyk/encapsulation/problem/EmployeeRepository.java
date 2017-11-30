package com.pszymczyk.encapsulation.problem;

import java.util.List;

/**
 * @author pawel szymczyk
 */
interface EmployeeRepository {
    List<Employee> findAllFromSalesUnit();
}
