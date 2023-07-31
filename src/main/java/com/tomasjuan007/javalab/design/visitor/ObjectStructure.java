package com.tomasjuan007.javalab.design.visitor;

public class ObjectStructure {
    private final Employee[] employees;

    public ObjectStructure(Employee... elements) {
        this.employees = elements;
    }

    public void accept(Visitor visitor) {
        for (Employee e : employees) {
            e.accept(visitor);
        }
    }

}