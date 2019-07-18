package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.List;

public class ResolverTest {

    private static StepDefinition _100_101 = new StepDefinition("1.0.0", "1.0.1");
    private static StepDefinition _101_102 = new StepDefinition("1.0.1", "1.0.2");
    private static StepDefinition _102_103 = new StepDefinition("1.0.2", "1.0.3");
    private static StepDefinition _101_103 = new StepDefinition("1.0.1", "1.0.3");
    private static StepDefinition _103_105 = new StepDefinition("1.0.3", "1.0.5");
    private static StepDefinition _105_110 = new StepDefinition("1.0.5", "1.1.0");
    private static List<StepDefinition> steps = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        steps.add(_100_101);
        steps.add(_101_102);
        steps.add(_102_103);
        steps.add(_101_103);
        steps.add(_103_105);
        steps.add(_105_110);
        PathResolver pathResolver = new PathResolver(steps);

        Path bestPath = pathResolver.findBestPath("1.0.0", "1.0.3");
        Path resultPath = new Path(new StepDefinition[] { _100_101, _101_103 });
        if (!bestPath.equals(resultPath)) {
            throw new Exception();
        }
        System.out.println();
        bestPath = pathResolver.findBestPath("1.0.1", "1.0.5");
        resultPath = new Path(new StepDefinition[] { _101_103, _103_105 });
        if (!bestPath.equals(resultPath)) {
            throw new Exception();
        }

    }
}
