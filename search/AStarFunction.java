package search;

public class AStarFunction implements NodeFunction {
    private NodeFunction heuristicFunction;

    public AStarFunction(NodeFunction heuristicFunction) {
        this.heuristicFunction = heuristicFunction;
    }

    @Override
    public int getValue(Node n) {
        return n.cost + heuristicFunction.getValue(n);
    }
}
