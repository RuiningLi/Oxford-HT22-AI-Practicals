package tour;

import search.*;

public class AStarGS_Demo {
    public static void main(String[] args) {
        System.out.println("This is a demonstration of A-Star graph search on Romania tour");
        System.out.println();

        Cities romania = SetUpRomania.getRomaniaMap();
        City startCity = romania.getState("Bucharest");

        GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);

        NodeFunction nodeFunction = new AStarFunction(new TourHeuristicFunction(romania.getAllCities(), startCity));
        Frontier bestFirstFrontier = new BestFirstFrontier(nodeFunction);
        Search AStarGraphSearch = new GraphSearch(bestFirstFrontier);
        Node solution = AStarGraphSearch.findSolution(new TourState(startCity), goalTest);
        new TourPrinting().printSolution(solution);
        System.out.println("Performance of breadth-first tree search: number of nodes generated " +
                AStarGraphSearch.getNumberOfNodesGenerated() +
                "; maximum number of nodes stored on the frontier " +
                bestFirstFrontier.getMaximumNodesStored());
    }
}
