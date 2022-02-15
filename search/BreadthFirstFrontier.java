package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {
    private Queue<Node> breadthFirstFrontier = new LinkedList<>();
    private int maximumNodesStored = 0;

    public void add(Node node) {
        maximumNodesStored = Math.max(maximumNodesStored, breadthFirstFrontier.size());
        breadthFirstFrontier.add(node);
    }
    public void clear() {
        breadthFirstFrontier.clear();
    }
    public boolean isEmpty() {
        return breadthFirstFrontier.isEmpty();
    }
    public Node remove() {
        assert(!this.isEmpty());
        return breadthFirstFrontier.remove();
    }

    @Override
    public int getMaximumNodesStored() {
        return maximumNodesStored;
    }
}
