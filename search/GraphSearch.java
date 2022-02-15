package search;

import java.util.HashSet;

public class GraphSearch implements Search {
    private Frontier frontier;
    private int numNodes;

    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
    }
    @Override
    public Node findSolution(State initialConfiguration, GoalTest goalTest) {
        HashSet<State> visitedStates = new HashSet<>();
        frontier.add(new Node(null, null, initialConfiguration));
        numNodes = 1;
        visitedStates.add(initialConfiguration);
        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if (goalTest.isGoal(node.state))
                return node;
            else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    if (!visitedStates.contains(newState)) {
                        frontier.add(new Node(node, action, newState));
                        visitedStates.add(newState);
                        ++numNodes;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int getNumberOfNodesGenerated() {
        return numNodes;
    }
}
