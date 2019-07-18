package com.tomasjuan007.javalab.tree;

class TreeNode {

    private String value;
    private StepDefinition stepDefinition;
    private Tree childTree;

    TreeNode(String value, StepDefinition stepDefinition) {
        this.value = value;
        this.stepDefinition = stepDefinition;
    }

    String getValue() {
        return value;
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
