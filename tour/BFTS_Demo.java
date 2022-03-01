package tour;

import search.*;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on Romania tour");
		System.out.println();
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		Frontier breathFirstFrontier = new BreadthFirstFrontier();
		Search breathFirstTreeSearch = new TreeSearch(breathFirstFrontier);
		Node solution = breathFirstTreeSearch.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution);
		System.out.println("Performance of breadth-first tree search: number of nodes generated " +
				breathFirstTreeSearch.getNumberOfNodesGenerated() +
				"; maximum number of nodes stored on the frontier " +
				breathFirstFrontier.getMaximumNodesStored());
	}
}
