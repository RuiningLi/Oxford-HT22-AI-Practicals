package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
    private Stack<Node> depthFirstFrontier = new Stack<>();
    private int maximumNodesStored = 0;

    public void add(Node node) {
        depthFirstFrontier.add(node);
        maximumNodesStored = Math.max(maximumNodesStored, depthFirstFrontier.size());
    }
    public void clear() {
        depthFirstFrontier.clear();
    }
    public boolean isEmpty() {
        return depthFirstFrontier.isEmpty();
    }
    public Node remove() {
        assert(!this.isEmpty());
        return depthFirstFrontier.pop();
    }

    @Override
    public int getMaximumNodesStored() {
        return maximumNodesStored;
    }
}
