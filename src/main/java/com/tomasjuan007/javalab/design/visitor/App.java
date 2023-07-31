package com.tomasjuan007.javalab.design.visitor;

public class App {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure(
                new Employee("Jack", 1, 10),
                new Employee("John", 1, 5),
                new Employee("Lily", 2, 15));
        os.accept(new EmployeeVisitor());
    }
}
