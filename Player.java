/***
 * A player in the game.
 * 
 * @author David
 */
public class Player extends Animate{

	public Player(Room r) {
		super(r, Game.PLAYER);
		loc = new Location(currentRoom.getHeight() / 2, currentRoom.getWidth() / 2);
		r.put(loc.row, loc.col, Game.PLAYER);
	}

	public void moveToward(Entity e){
		moveToward(e.loc);
	}


	// returns true if player was able to move in that direction.
	public boolean ableToMove(int direction) {
		Location moveTo = Location.locationInDirection(loc, direction);

		if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
			currentRoom.moveElementAt(loc, direction);

			loc = moveTo; // update own location
			return true;
		}

		return false;
	}

	public void escape() {
		Location newLocation;

		do {
			newLocation = currentRoom.getRandomLocation();
		} while (!currentRoom.isEmpty(newLocation));

		currentRoom.put(loc.row, loc.col, Game.EMPTY);
		currentRoom.put(newLocation.row, newLocation.col, Game.PLAYER);

		this.loc = newLocation;

	}

	// returns sum of difference of rows and difference of columns
	public int getDistanceTo(Wumpus w) {
		int colSum = Math.abs(loc.col - w.getCol());
		int rowSum = Math.abs(loc.row - w.getRow());
		return colSum + rowSum;
	}

	@Override
	public String toString() {
		return "*";
	}
	
}