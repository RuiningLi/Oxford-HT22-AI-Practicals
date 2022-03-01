package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int depth;
	public int value;
	public int cost;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
	}

	public Node(Node parent, Action action, State state, int depth) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = depth;
	}

	public Node(Node parent, Action action, State state, int value, int cost) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.value = value;
		this.cost = cost;
	}
}