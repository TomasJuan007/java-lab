package com.tomasjuan007.javalab.design.visitor;

public interface Element {
    void accept(Visitor visitor);
}
