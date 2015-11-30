
public class Animate extends Entity {
	private boolean isAlive;
	private int row, col;

	public Animate(Room r, Location loc) {
		super(r, loc);
		this.row = loc.row;
		this.col = loc.col;
	}

	public void randomMove() {
		int d = (int) (Math.random() * 4);
		move(d);
	}

	public boolean move(int direction) {
		int newrow = row;
		int newcol = col;

		if (direction == Location.NORTH)
			newrow--;
		if (direction == Location.SOUTH)
			newrow++;
		if (direction == Location.EAST)
			newcol++;
		if (direction == Location.WEST)
			newcol--;

		if (currentRoom.isEmpty(newrow, newcol)) {
			currentRoom.put(row, col, 0);
			currentRoom.put(newrow, newcol, 3);
			row = newrow;
			col = newcol;
			return true;
		}

		return false;
	}
	public void moveTowards(Location l){
		
	}
}
