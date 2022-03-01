package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
    @Override
    public int getValue(Node n) {
        return 0;
    }
}
