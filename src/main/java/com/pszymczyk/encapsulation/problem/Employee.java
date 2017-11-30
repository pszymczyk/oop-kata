package com.pszymczyk.encapsulation.problem;

/**
 * @author pawel szymczyk
 */
class Employee {

    private final int id;
    private Employee boss;

    public static Employee boss(int id) {
        return new Employee(id);
    }

    public static Employee employee(int id, Employee boss) {
        return new Employee(id, boss);
    }

    private Employee(int id) {
        this.id = id;
    }

    private Employee(int id, Employee boss) {
        this.id = id;
        this.boss = boss;
    }

    public void changeBoss(Employee boss) {
        this.boss = boss;
    }

    public int getId() {
        return id;
    }

    public Employee getBoss() {
        return boss;
    }

}
