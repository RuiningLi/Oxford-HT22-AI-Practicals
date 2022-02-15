package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {
    private Queue<Node> breadthFirstFrontier = new LinkedList<>();

    public void add(Node node) {
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
}
