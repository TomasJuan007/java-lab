package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {

    private List<StepDefinition> steps = new ArrayList<>();

    Path() {
    }

    Path(StepDefinition[] step) {
        this.steps.addAll(Arrays.asList(step));
    }

    void addStep(StepDefinition step) {
        steps.add(step);
    }

    boolean isBetterThan(Path other) {
        boolean result;
        if (steps.isEmpty()) {
            result = false;
        } else if (other == null) {
            result = true;
        } else {
            result = steps.size() <= other.steps.size();
        }
        return result;
    }

    void addPath(Path path) {
        if (path != null) {
            steps.addAll(path.steps);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((steps == null) ? 0 : steps.hashCode());
        return result;
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
        return steps.toString();
    }
}
