package com.tomasjuan007.javalab.tree;

import java.util.List;

class PathResolver {

    private List<StepDefinition> availableSteps;

    PathResolver(List<StepDefinition> availableSteps) {
        this.availableSteps = availableSteps;
    }

    Path findBestPath(String from, String to) {
        Tree tree = getTree(from, to);
        return getBestPath(tree, to);
    }

    private Tree getTree(String from, String to) {
        Tree resultTree = new Tree();

        for (StepDefinition definition : availableSteps) {
            TreeNode node;
            if (definition.getFromVersion().equals(from)) {
                node = new TreeNode(definition);
                if (!definition.getToVersion().equals(to)) {
                    Tree next = getTree(definition.getToVersion(), to);
                    if (getBestPath(next, to) != null) {
                        node.setChildTree(next);
                    }
                }
                resultTree.addNode(node);
            }
        }
        return resultTree;
    }

    Path getBestPath(Tree tree, String value) {
        Path result = null;
        for (TreeNode node : tree.getNodes()) {
            Path candidatePath = new Path();
            if (node.getStepDefinition().getToVersion().equals(value)) {
                candidatePath.addStep(node.getStepDefinition());
            } else if (node.getChildTree() != null) {
                candidatePath.addStep(node.getStepDefinition());
                Path temp = getBestPath(node.getChildTree(), value);
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
