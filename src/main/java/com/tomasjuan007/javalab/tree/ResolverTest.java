package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.List;

public class ResolverTest {

    private static StepDefinition _A_B = new StepDefinition("A", "B");
    private static StepDefinition _B_C = new StepDefinition("B", "C");
    private static StepDefinition _C_D = new StepDefinition("C", "D");
    private static StepDefinition _B_D = new StepDefinition("B", "D");
    private static StepDefinition _D_E = new StepDefinition("D", "E");
    private static StepDefinition _C_E = new StepDefinition("A", "D");
    private static List<StepDefinition> steps = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        steps.add(_A_B);
        steps.add(_B_C);
        steps.add(_C_D);
        steps.add(_B_D);
        steps.add(_D_E);
        steps.add(_C_E);
        PathResolver pathResolver = new PathResolver(steps);

        Path bestPath = pathResolver.findBestPath("A", "D");
        System.out.println(verify(bestPath, _A_B, _B_D));
        
        bestPath = pathResolver.findBestPath("B", "E");
        System.out.println(verify(bestPath, _B_D, _D_E));

        bestPath = pathResolver.findBestPath("A", "E");
        System.out.println(bestPath);
    }

    public static boolean verify(Path bestPath, StepDefinition... args) throws Exception {
        boolean result = true;
        int argsSize = args.length;
        List<StepDefinition> bestPathSteps = bestPath.getSteps();
        if (bestPathSteps.size() != argsSize) {
            return false;
        }
        for (int index = 0; index < bestPathSteps.size(); index++) {
            if (!bestPathSteps.get(index).equals(args[index])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
