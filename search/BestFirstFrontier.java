package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {
    private PriorityQueue<Node> bestFirstFrontier = new PriorityQueue<>(Comparator.comparingInt(x -> x.value));
    private NodeFunction nodeFunction;
    private int maximumNodesStored = 0;

    public BestFirstFrontier(NodeFunction nodeFunction) {
        this.nodeFunction = nodeFunction;
    }

    @Override
    public void add(Node node) {
        node.value = nodeFunction.getValue(node);
        bestFirstFrontier.add(node);
        maximumNodesStored = Math.max(maximumNodesStored, bestFirstFrontier.size());
    }

    @Override
    public void clear() {
        bestFirstFrontier.clear();
    }

    @Override
    public boolean isEmpty() {
        return bestFirstFrontier.isEmpty();
    }

    @Override
    public Node remove() {
        return bestFirstFrontier.poll();
    }

    @Override
    public int getMaximumNodesStored() {
        return maximumNodesStored;
    }
}
