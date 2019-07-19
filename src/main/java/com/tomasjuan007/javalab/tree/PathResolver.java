package com.tomasjuan007.javalab.tree;

import java.util.List;

class PathResolver {

    private List<StepDefinition> availableSteps;

    PathResolver(List<StepDefinition> availableSteps) {
        this.availableSteps = availableSteps;
    }

    Path findBestPath(String from, String to) {
        Tree tree = getTree(from, to);
        return tree.getBestPath();
    }

    private Tree getTree(String from, String to) {
        Tree resultTree = new Tree(to);
        System.out.println(String.format("Determining tree (%s to %s)", from, to));

        for (StepDefinition definition : availableSteps) {
            TreeNode node;
            if (definition.getFromVersion().equals(from)) {
                System.out.println(String.format("Matched from %s with %s", from, definition));
                node = new TreeNode(definition.getToVersion(), definition);
                if (!definition.getToVersion().equals(to)) {
                    System.out.println(String.format("To %s did not match with %s, searching deeper using (%s, %s)", to, definition, definition.getToVersion(), to));
                    Tree next = getTree(definition.getToVersion(), to);
                    if (next.getBestPath() != null) {
                        System.out.println(String.format("Found step (%s, %s): %s", from, definition.getToVersion(), next.getBestPath()));
                        node.setChildTree(next);
                    } else {
                        System.out.println(String.format("Detected a dead end (%s, %s)", from, to));
                    }
                } else {
                    System.out.println(String.format("Matched to %s with %s -> path complete!", to, definition));
                }
                resultTree.addNode(node);
            }
        }
        return resultTree;
    }

}
