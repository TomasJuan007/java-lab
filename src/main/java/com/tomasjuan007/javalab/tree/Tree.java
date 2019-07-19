package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.List;

class Tree {

    private String value;
    private List<TreeNode> nodes = new ArrayList<>();

    Tree(String value) {
        this.value = value;
    }

    void addNode(TreeNode node) {
        nodes.add(node);
    }

    Path getBestPath() {
        Path result = null;
        for (TreeNode node : nodes) {
            Path candidatePath = new Path();
            if (node.getValue().equals(value)) {
                candidatePath.addStep(node.getStepDefinition());
            } else if (node.getChildTree() != null) {
                candidatePath.addStep(node.getStepDefinition());
                Path temp = node.getChildTree().getBestPath();
                if (temp != null) {
                    for (StepDefinition step : temp.getSteps()) {
                        candidatePath.addStep(step);
                    }
                }
            }
            if (!candidatePath.getSteps().isEmpty() &&
                    (result == null || candidatePath.getSteps().size() <= result.getSteps().size())) {
                result = candidatePath;
            }
        }
        return result;
    }
}
