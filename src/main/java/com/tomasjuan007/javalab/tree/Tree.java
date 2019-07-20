package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.List;

class Tree {

    private List<TreeNode> nodes = new ArrayList<>();

    List<TreeNode> getNodes() {
        return this.nodes;
    }

    void addNode(TreeNode node) {
        nodes.add(node);
    }
}
