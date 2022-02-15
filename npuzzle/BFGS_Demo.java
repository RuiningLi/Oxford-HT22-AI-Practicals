package npuzzle;

import search.*;

public class BFGS_Demo {
    public static void main(String[] args) {
        System.out.println("This is a demonstration of breadth-first graph search on 8-puzzle");
        System.out.println();

        Tiles initialConfiguration = new Tiles(new int[][]{
                {7, 4, 2},
                {8, 1, 3},
                {5, 0, 6}
        });

        GoalTest goalTest = new TilesGoalTest();
        Frontier breathFirstFrontier = new BreadthFirstFrontier();
        Search breathFirstGraphSearch = new GraphSearch(breathFirstFrontier);
        Node solution = breathFirstGraphSearch.findSolution(initialConfiguration, goalTest);
        new NPuzzlePrinting().printSolution(solution);
        System.out.println("Performance of breadth-first tree search: number of nodes generated " +
                breathFirstGraphSearch.getNumberOfNodesGenerated() +
                "; maximum number of nodes stored on the frontier " +
                breathFirstFrontier.getMaximumNodesStored());
    }
}
