package npuzzle;

import search.Action;

public enum Movement implements Action {
	UP(-1, 0), LEFT(0, -1), DOWN(1, 0), RIGHT(0, 1);

	public final int deltaRow;
	public final int deltaColumn;
	
	Movement(int deltaRow, int deltaColumn) {
		this.deltaRow = deltaRow;
		this.deltaColumn = deltaColumn;
	}

	@Override
	public int cost() {
		return 1;
	}
}
