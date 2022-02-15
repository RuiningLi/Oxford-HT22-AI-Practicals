package tour;

import search.*;

public class IDS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on Romania tour");
		System.out.println();
		
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		IterativeDeepeningTreeSearch iterativeDeepeningTreeSearch = new IterativeDeepeningTreeSearch();
		Node solution = iterativeDeepeningTreeSearch.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution);
		System.out.println("Performance of breadth-first tree search: number of nodes generated " +
				iterativeDeepeningTreeSearch.getNumberOfNodesGenerated() +
				"; maximum number of nodes stored on the frontier " +
				(iterativeDeepeningTreeSearch).getMaximumNodesStored());
	}
}
