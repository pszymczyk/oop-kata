package com.pszymczyk.encapsulation.problem;


import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pawel szymczyk
 */
public class MexicanInternProgrammerSalesUnitFactoryTest {

    @Test
    @Ignore
    public void shouldBreaksEncapsulation() {
        //given
        final Employee john = Employee.boss(1 );
        final Employee chris = Employee.employee(2, john);
        final Employee justin = Employee.employee(3, john);
        final Employee cindy = Employee.employee(4, justin);
        final Employee wenwei = Employee.employee(5, cindy);


        EmployeeRepository employeeRepository = new EmployeeRepository() {
            @Override
            public List<Employee> findAllFromSalesUnit() {
                return Arrays.asList(john, chris, justin, cindy, wenwei);
            }
        };

        //when
        MexicanInternProgrammerSalesUnitFactory factory = new MexicanInternProgrammerSalesUnitFactory(employeeRepository);
        SalesUnit salesUnit = factory.create();

        // then cindy's boss is justin
        assertThat(salesUnit.findBoss(cindy.getId()).getId()).isEqualTo(justin.getId());

        // do something nasty
        for (Employee employee: factory.getEmployees()) {
            if (employee.getId() == cindy.getId()) {
                employee.changeBoss(john);
            }
        }

        //or just
        salesUnit.findBoss(wenwei.getId()).changeBoss(john);

        // then cindy's boss is justin
        assertThat(salesUnit.findBoss(cindy.getId()).getId()).isEqualTo(justin.getId());
    }

}