package com.tomasjuan007.javalab.tree;

class TreeNode {
    private Step step;
    private Tree childTree;

    TreeNode(Step step) {
        this.step = step;
    }

    Step getStep() {
        return step;
    }

    Tree getChildTree() {
        return childTree;
    }

    void setChildTree(Tree childTree) {
        this.childTree = childTree;
    }

}
