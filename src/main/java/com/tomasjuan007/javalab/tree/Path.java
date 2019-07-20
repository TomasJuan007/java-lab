package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<StepDefinition> steps = new ArrayList<>();

    List<StepDefinition> getSteps() {
        return steps;
    }

    void addStep(StepDefinition step) {
        steps.add(step);
    }

    public String toString() {
        return "[Path]"+steps.toString();
    }
}
