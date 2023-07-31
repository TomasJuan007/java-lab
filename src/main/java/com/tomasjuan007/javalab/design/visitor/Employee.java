package com.tomasjuan007.javalab.design.visitor;

public class Employee implements Element {
    private String name;
    private int degree;
    private int vacationDays;

    public Employee(String name, int degree, int vacationDays) {
        this.name = name;
        this.degree = degree;
        this.vacationDays = vacationDays;
    }

    public String getName() {
        return name;
    }

    public int getDegree() {
        return degree;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
