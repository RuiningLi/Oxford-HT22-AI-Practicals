package search;

public class TreeSearch implements Search {
    private Frontier frontier;
    private int numNodes;

    public TreeSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    @Override
    public Node findSolution(State initialConfiguration, GoalTest goalTest) {
        frontier.add(new Node(null, null, initialConfiguration));
        numNodes = 1;
        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if (goalTest.isGoal(node.state))
                return node;
            else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    frontier.add(new Node(node, action, newState));
                    ++numNodes;
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
