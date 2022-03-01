package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int depth = 0;
	public int value;
	public int cost = 0;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		if (parent != null && action != null) {
			this.depth = parent.depth + 1;
			this.cost = parent.cost + action.cost();
		}
	}
}