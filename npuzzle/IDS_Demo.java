package npuzzle;

import search.*;

public class IDS_Demo {
    public static void main(String[] args) {
        System.out.println("This is a demonstration of iterative search on 8-puzzle");
        System.out.println();

        Tiles initialConfiguration = new Tiles(new int[][]{
                {7, 4, 2},
                {8, 1, 3},
                {5, 0, 6}
        });

        GoalTest goalTest = new TilesGoalTest();
        IterativeDeepeningTreeSearch iterativeDeepeningTreeSearch = new IterativeDeepeningTreeSearch();
        Node solution = iterativeDeepeningTreeSearch.findSolution(initialConfiguration, goalTest);
        new NPuzzlePrinting().printSolution(solution);
        System.out.println("Performance of breadth-first tree search: number of nodes generated " +
                iterativeDeepeningTreeSearch.getNumberOfNodesGenerated() +
                "; maximum number of nodes stored on the frontier " +
                (iterativeDeepeningTreeSearch).getMaximumNodesStored());
    }
}
