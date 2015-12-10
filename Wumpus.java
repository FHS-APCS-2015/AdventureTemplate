/***
 * An enemy which can occupy a location in a room and is not to be touched.
 * 
 * @author David
 */
public class Wumpus extends Enemy {
	private Room currentRoom; // room the Wumpus is in
	private int row, col; // the location of the wumpus in the room

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public Wumpus(Room r) {
		super(r);
		currentRoom = r;
		row = 6;
		col = 8;
		currentRoom.put(row, col, Game.WUMPUS); // THIS IS BAD. WHY?
	}

	public int directionTo(Player p) {
		int direction = 0, greatestDist = 0;
		if (p.loc.row > loc.row && Math.abs(p.loc.row - loc.row) > greatestDist) {
			direction = Location.NORTH;
			greatestDist = Math.abs(p.loc.row - loc.row);
		}
		if (p.loc.row < loc.row && Math.abs(p.loc.row - loc.row) > greatestDist) {
			direction = Location.SOUTH;
			greatestDist = Math.abs(p.loc.row - loc.row);
		}
		if (p.loc.col > loc.col && Math.abs(p.loc.col - loc.col) > greatestDist) {
			direction = Location.EAST;
			greatestDist = Math.abs(p.loc.col - loc.col);
		}
		if (p.loc.col < loc.col && Math.abs(p.loc.col - loc.col) > greatestDist) {
			direction = Location.WEST;
			greatestDist = Math.abs(p.loc.col - loc.col);
		}
		return direction;
	}

	public void flash() {
		move(Location.EAST);
		move(Location.WEST);
		move(Location.EAST);
		move(Location.WEST);
	}

	// returns true if enemy was able to move in that direction.
	public boolean ableToMove(int direction) {
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

	public void randomMove() {
		int random = (int) (Math.random() * 4);
		move(random);
	}

	// happens when we call the attack command
	public void disappear() {
		currentRoom.put(row, col, Game.EMPTY);
	}
}