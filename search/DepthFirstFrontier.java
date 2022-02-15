package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
    private Stack<Node> depthFirstFrontier = new Stack<>();

    public void add(Node node) {
        depthFirstFrontier.add(node);
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
}
