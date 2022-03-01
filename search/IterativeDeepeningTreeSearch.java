package search;

public class IterativeDeepeningTreeSearch implements Search {
    private Frontier frontier = new DepthFirstFrontier();
    private int numberOfNodesGenerated = 0;

    @Override
    public Node findSolution(State initialConfiguration, GoalTest goalTest) {
        numberOfNodesGenerated = 0;
        for (int depth = 0; ; ++depth) {
            boolean cutoff = false;
            frontier.clear();
            frontier.add(new Node(null, null, initialConfiguration));
            ++numberOfNodesGenerated;
            while (!frontier.isEmpty()) {
                Node node = frontier.remove();
                if (goalTest.isGoal(node.state))
                    return node;
                if (node.depth == depth)
                    cutoff = true;
                else {
                    for (Action action : node.state.getApplicableActions()) {
                        State newState = node.state.getActionResult(action);
                        frontier.add(new Node(node, action, newState));
                        ++numberOfNodesGenerated;
                    }
                }
            }
            if (!cutoff) return null;
        }
    }

    @Override
    public int getNumberOfNodesGenerated() {
        return numberOfNodesGenerated;
    }

    public int getMaximumNodesStored() {
        return frontier.getMaximumNodesStored();
    }
}
