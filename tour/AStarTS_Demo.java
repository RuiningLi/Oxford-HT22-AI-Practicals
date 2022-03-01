package tour;

import search.*;

public class AStarTS_Demo {
    public static void main(String[] args) {
        System.out.println("This is a demonstration of A-Star graph search on Romania tour");
        System.out.println();

        Cities romania = SetUpRomania.getRomaniaMap();
        City startCity = romania.getState("Bucharest");

        GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);

        NodeFunction nodeFunction = new AStarFunction(new TourHeuristicFunction(romania.getAllCities(), startCity));
        Frontier bestFirstFrontier = new BestFirstFrontier(nodeFunction);
        Search AStarTreeSearch = new TreeSearch(bestFirstFrontier);
        Node solution = AStarTreeSearch.findSolution(new TourState(startCity), goalTest);
        new TourPrinting().printSolution(solution);
        System.out.println("Performance of breadth-first tree search: number of nodes generated " +
                AStarTreeSearch.getNumberOfNodesGenerated() +
                "; maximum number of nodes stored on the frontier " +
                bestFirstFrontier.getMaximumNodesStored());
    }
}
