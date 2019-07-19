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

    public boolean equals(Object obj) {
        boolean result = true;
        if (!(obj instanceof Path)) {
            result = false;
        } else {
            Path other = (Path) obj;
            for (int index = 0; index < steps.size(); index++) {
                if (other.steps.size() < index || !steps.get(index).equals(other.steps.get(index))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public String toString() {
        return "[Path]"+steps.toString();
    }
}
