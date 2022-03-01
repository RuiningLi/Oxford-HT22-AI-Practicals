package npuzzle;

import search.*;

public class AStarTS_Demo {
    public static void main(String[] args) {
        System.out.println("This is a demonstration of A-Star tree search on 8-puzzle");
        System.out.println();

        Tiles initialConfiguration = new Tiles(new int[][]{
                {7, 4, 2},
                {8, 1, 3},
                {5, 0, 6}
        });

        GoalTest goalTest = new TilesGoalTest();
        NodeFunction nodeFunction = new MisplacedTilesHeuristicFunction();
        Frontier bestFirstFrontier = new BestFirstFrontier(nodeFunction);
        Search AStarTreeSearch = new TreeSearch(bestFirstFrontier);
        Node solution = AStarTreeSearch.findSolution(initialConfiguration, goalTest);
        new NPuzzlePrinting().printSolution(solution);
        System.out.println("Performance of breadth-first tree search: number of nodes generated " +
                AStarTreeSearch.getNumberOfNodesGenerated() +
                "; maximum number of nodes stored on the frontier " +
                bestFirstFrontier.getMaximumNodesStored());
    }
}
