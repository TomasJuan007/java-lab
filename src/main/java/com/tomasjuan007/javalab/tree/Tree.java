package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.List;

class Tree {

    private String to;
    private List<TreeNode> nodes = new ArrayList<>();

    Tree(String to) {
        this.to = to;
    }

    void addNode(TreeNode node) {
        nodes.add(node);
    }

    boolean containsValidPath() {
        return getBestPath() != null;
    }

    Path getBestPath() {
        Path result = null;
        for (TreeNode node : nodes) {
            Path candidatePath = new Path();
            if (node.getValue().equals(to)) {
                candidatePath.addStep(node.getStepDefinition());
            } else if (node.getChildTree() != null) {
                candidatePath.addStep(node.getStepDefinition());
                candidatePath.addPath(node.getChildTree().getBestPath());
            }
            if (candidatePath.isBetterThan(result)) {
                result = candidatePath;
            }
        }
        return result;
    }
}
