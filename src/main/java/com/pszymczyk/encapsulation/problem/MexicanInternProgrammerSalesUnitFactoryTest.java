package com.pszymczyk.encapsulation.problem;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pawel szymczyk
 */
public class MexicanInternProgrammerSalesUnitFactoryTest {

    @Test
    public void shouldBreaksEncapsulation() {
        //given
        Employee john = Employee.boss(1 );
        Employee chris = Employee.employee(2, john);
        Employee justin = Employee.employee(3, john);
        Employee cindy = Employee.employee(4, justin);
        Employee wenwei = Employee.employee(5, cindy);


        EmployeeRepository employeeRepository = () -> Arrays.asList(john, chris, justin, cindy, wenwei);

        //when
        MexicanInternProgrammerSalesUnitFactory factory = new MexicanInternProgrammerSalesUnitFactory(employeeRepository);
        SalesUnit salesUnit = factory.create();

        // then cindy's boss is justin
        assertThat(salesUnit.findBoss(cindy.getId()).getId()).isEqualTo(justin.getId());

        // do something nasty
        factory.getEmployees().stream()
                .filter(e -> e.getId() == cindy.getId())
                .findFirst()
                .get()
                .changeBoss(john);


        //or just
        salesUnit.findBoss(wenwei.getId()).changeBoss(john);

        // then cindy's boss is justin
        assertThat(salesUnit.findBoss(cindy.getId()).getId()).isEqualTo(justin.getId());
    }

}