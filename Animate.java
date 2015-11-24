
public class Animate extends GameToken {
	private boolean alive;

	public Animate(Room r, int type) {
		super(r, type);

	}

	public Animate(Room r, Location loc, int type) {
		super(r, loc, type);
	}

	// returns true if player was able to move in that direction.
	public boolean move(int direction) {
		Location moveTo = Location.locationInDirection(loc, direction);

		if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
			currentRoom.moveElementAt(loc, direction);

			loc = moveTo; // update own location
			return true;
		}

		return false;
	}
	
	public void randomTeleport() {
		Location newLoc = currentRoom.getRandomEmptyLocation();
		currentRoom.moveObject(loc, newLoc);
		this.loc = newLoc;
	}
	
	public void randomMove() {
		boolean moved = false;
		do {
			moved = move(currentRoom.getRandomDirection());
		} while (moved == false);
	}
}
