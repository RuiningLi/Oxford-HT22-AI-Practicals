package tour;

import search.*;

public class BFGS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first graph search on Romania tour");
		System.out.println();
		
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		Frontier breathFirstFrontier = new BreadthFirstFrontier();
		Search breathFirstGraphSearch = new GraphSearch(breathFirstFrontier);
		Node solution = breathFirstGraphSearch.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution);
		System.out.println("Performance of breadth-first tree search: number of nodes generated " +
				breathFirstGraphSearch.getNumberOfNodesGenerated() +
				"; maximum number of nodes stored on the frontier " +
				breathFirstFrontier.getMaximumNodesStored());
	}
}
