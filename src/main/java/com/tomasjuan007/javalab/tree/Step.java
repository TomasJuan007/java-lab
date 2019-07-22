package com.tomasjuan007.javalab.tree;

class Step {
    private String from;
    private String to;

    Step(String from, String to) {
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
        return "Step("+from+"->"+to+")";
    }
}
