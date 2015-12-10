
public abstract class Animate extends Entity {
	boolean alive;

	public Animate(Room r) {
		super(r);
	}

	public Animate(Room r, Location loc) {
		super(r, loc);
	}
	public Animate(Room r, Location loc, int gameVar) {
		super(r, loc, gameVar);
	}
	public Animate(Room r, int gameVar) {
		super(r, gameVar);
	}

	public void move(int direction) {
    	System.out.println("move initiated");
		Location moveTo = Location.locationInDirection(loc, direction);

		if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {

	    	System.out.println("actual moving and updating initiated");
			currentRoom.moveElementAt(loc, direction);

			loc = moveTo; // update own location
		}
	}

	public void moveRandom() {
		int random = (int) (Math.random() * 4);
		move(random);
	}

	public void moveToward(Location loc) {
		int direction = 0, greatestDist = 0;
		if (loc.row > this.loc.row && Math.abs(loc.row - this.loc.row) > greatestDist) {
			direction = Location.NORTH;
			greatestDist = Math.abs(loc.row - this.loc.row);
		}
		if (loc.row < this.loc.row && Math.abs(loc.row - this.loc.row) > greatestDist) {
			direction = Location.SOUTH;
			greatestDist = Math.abs(loc.row - this.loc.row);
		}
		if (loc.col > this.loc.col && Math.abs(loc.col - this.loc.col) > greatestDist) {
			direction = Location.EAST;
			greatestDist = Math.abs(loc.col - this.loc.col);
		}
		if (loc.col < this.loc.col && Math.abs(loc.col - this.loc.col) > greatestDist) {
			direction = Location.WEST;
			greatestDist = Math.abs(loc.col - this.loc.col);
		}
		move(direction);
	}	
}
