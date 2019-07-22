package com.tomasjuan007.javalab.tree;

import java.util.List;

class PathResolver {

    private List<Step> availableSteps;

    PathResolver(List<Step> availableSteps) {
        this.availableSteps = availableSteps;
    }

    Path findBestPath(String from, String to) {
        Tree tree = getTree(from, to);
        return getBestPath(tree, to);
    }

    private Tree getTree(String from, String to) {
        Tree resultTree = new Tree();

        for (Step step : availableSteps) {
            TreeNode node;
            if (step.getFromVersion().equals(from)) {
                node = new TreeNode(step);
                if (!step.getToVersion().equals(to)) {
                    Tree next = getTree(step.getToVersion(), to);
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
            if (node.getStep().getToVersion().equals(value)) {
                candidatePath.addStep(node.getStep());
            } else if (node.getChildTree() != null) {
                candidatePath.addStep(node.getStep());
                Path temp = getBestPath(node.getChildTree(), value);
                if (temp != null) {
                    for (Step step : temp.getSteps()) {
                        candidatePath.addStep(step);
                    }
                }
            }
            if (!candidatePath.getSteps().isEmpty() && (result == null
                    || candidatePath.getSteps().size() <= result.getSteps().size())) {
                result = candidatePath;
            }
        }
        return result;
    }

}
