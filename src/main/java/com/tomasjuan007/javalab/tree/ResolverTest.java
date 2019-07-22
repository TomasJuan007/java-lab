package com.tomasjuan007.javalab.tree;

import java.util.ArrayList;
import java.util.List;

public class ResolverTest {

    private static Step _A_B = new Step("A", "B");
    private static Step _B_C = new Step("B", "C");
    private static Step _C_D = new Step("C", "D");
    private static Step _D_E = new Step("D", "E");
    private static Step _B_D = new Step("B", "D");
    private static Step _A_D = new Step("A", "D");
    private static List<Step> steps = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        steps.add(_A_B);
        steps.add(_B_C);
        steps.add(_C_D);
        steps.add(_D_E);
        steps.add(_B_D);
        steps.add(_A_D);
        PathResolver pathResolver = new PathResolver(steps);

        Path bestPath = pathResolver.findBestPath("A", "D");
        System.out.println(verify(bestPath, _A_B, _B_D));
        
        bestPath = pathResolver.findBestPath("B", "E");
        System.out.println(verify(bestPath, _B_D, _D_E));

        bestPath = pathResolver.findBestPath("A", "E");
        System.out.println(bestPath);
    }

    public static boolean verify(Path bestPath, Step... args) throws Exception {
        boolean result = true;
        int argsSize = args.length;
        List<Step> bestPathSteps = bestPath.getSteps();
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
