package com.tomasjuan007.javalab.tree;

class StepDefinition {

    private String from;
    private String to;

    StepDefinition(String from, String to) {
        this.from = from;
        this.to = to;
    }

    String getFromVersion() {
        return from;
    }

    String getToVersion() {
        return to;
    }

    public String toString() {
        return "StepDefinition("+from+"->"+to+")";
    }
}
