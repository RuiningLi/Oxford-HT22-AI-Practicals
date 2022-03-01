package npuzzle;

import search.*;

public class AStarGS_Demo {
    public static void main(String[] args) {
        System.out.println("This is a demonstration of A-Star graph search on 8-puzzle");
        System.out.println();

        Tiles initialConfiguration = new Tiles(new int[][]{
                {7, 4, 2},
                {8, 1, 3},
                {5, 0, 6}
        });

        GoalTest goalTest = new TilesGoalTest();
        NodeFunction nodeFunction = new AStarFunction(new MisplacedTilesHeuristicFunction());
        Frontier bestFirstFrontier = new BestFirstFrontier(nodeFunction);
        Search AStarGraphSearch = new GraphSearch(bestFirstFrontier);
        Node solution = AStarGraphSearch.findSolution(initialConfiguration, goalTest);
        new NPuzzlePrinting().printSolution(solution);
        System.out.println("Performance of breadth-first tree search: number of nodes generated " +
                AStarGraphSearch.getNumberOfNodesGenerated() +
                "; maximum number of nodes stored on the frontier " +
                bestFirstFrontier.getMaximumNodesStored());
    }
}
