package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<Step> steps = new ArrayList<>();

    List<Step> getSteps() {
        return steps;
    }

    void addStep(Step step) {
        steps.add(step);
    }

    public String toString() {
        return "[Path]"+steps.toString();
    }
}
