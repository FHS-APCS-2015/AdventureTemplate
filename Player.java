/***
 * A player in the game.
 * 
 * @author David
 */
public class Player {
	private Room currentRoom; // room player is in
	private Location loc; // location of the player in the room

	public Player(Room r) {
		currentRoom = r;
		loc = new Location(currentRoom.getHeight() / 2, currentRoom.getWidth() / 2);
		currentRoom.put(loc.row, loc.col, Game.PLAYER);
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

	public boolean RandomMove() {
		for (int i = 0; i < 100; i++) {
			int direction = ((int) Math.random() * 4);
			Location moveTo = Location.locationInDirection(loc, direction);

			if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
				currentRoom.moveElementAt(loc, direction);

				loc = moveTo; // update own location
				return true;
			}
		}

		return false;
	}

}