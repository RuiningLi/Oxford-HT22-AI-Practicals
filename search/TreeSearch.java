package search;

public class TreeSearch implements Search {
    private Frontier frontier;
    private int numberOfNodesGenerated = 0;

    public TreeSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    @Override
    public Node findSolution(State initialConfiguration, GoalTest goalTest) {
        frontier.add(new Node(null, null, initialConfiguration));
        numberOfNodesGenerated = 1;
        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if (goalTest.isGoal(node.state))
                return node;
            else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    frontier.add(new Node(node, action, newState));
                    ++numberOfNodesGenerated;
                }
            }
        }
        return null;
    }

    @Override
    public int getNumberOfNodesGenerated() {
        return numberOfNodesGenerated;
    }
}
