package com.tomasjuan007.javalab.tree;

class TreeNode {
    private StepDefinition stepDefinition;
    private Tree childTree;

    TreeNode(StepDefinition stepDefinition) {
        this.stepDefinition = stepDefinition;
    }

    void setChildTree(Tree childTree) {
        this.childTree = childTree;
    }

    Tree getChildTree() {
        return childTree;
    }

    StepDefinition getStepDefinition() {
        return stepDefinition;
    }

}
