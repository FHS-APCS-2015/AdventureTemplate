
public class Animate extends Entity {
	boolean alive;

	public Animate(Room r, Location l) {
		super(r, l);
	}

	public boolean move(int direction) {
		Location moveTo = Location.locationInDirection(loc, direction);

		if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
			currentRoom.moveElementAt(loc, direction);

			loc = moveTo; // update own location
			return true;
		}

		return false;
	}

	public void moveToRandomDirection() {
		for (int i = 0; i < 10000; i++) {
			int rand = (int) (Math.random() * 4);
			move(rand);
		}
	}

	//TODO: finish moveTowards(..)
	public void moveTowards(Location l) {

	}

}
