package com.tomasjuan007.javalab.design.visitor;

public class EmployeeVisitor implements Visitor {

    @Override
    public void visit(Employee element) {
        System.out.println(
                element.getName() + "'s Compensation is " + (element.getDegree() * element.getVacationDays() * 10));
    }

}
