/***
 * A player in the game.
 * 
 * @author David
 */
public class Player implements Animate {
	private Room currentRoom; // room player is in
	private static Location loc; // location of the player in the room

	public Player(Room r) {
		currentRoom = r;
		loc = new Location(currentRoom.getHeight() / 2, currentRoom.getWidth() / 2);
		currentRoom.put(loc.row, loc.col, Game.PLAYER);
	}

	public void escape() {
		Location newLoc = currentRoom.getRandomLocation();
		currentRoom.moveEntity(loc, newLoc);
		this.loc = newLoc;

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

	public void move(Location loc) {
		this.loc = loc;
	}

	public static int getRow() {
		return loc.getRow();
	}

	// format for return: [row][col][value]
	public Location[] getNeighbors() {
		Location loc1 = new Location((getRow() - 1), (getCol() - 1));
		Location loc2 = new Location((getRow() - 1), (getCol()));
		Location loc3 = new Location((getRow() - 1), (getCol() + 1));
		Location loc4 = new Location((getRow()), (getCol() - 1));
		Location loc5 = new Location((getRow()), (getCol() + 1));
		Location loc6 = new Location((getRow() + 1), (getCol() - 1));
		Location loc7 = new Location((getRow() + 1), (getCol()));
		Location loc8 = new Location((getRow() + 1), (getCol() + 1));

		Location[] a = { loc1, loc2, loc3, loc4, loc5, loc6, loc7, loc8 };
		return a;
	}

	public void attack() {
		Location[] location = getNeighbors();

	}

	public static int getCol() {
		return loc.getCol();

	}

	@Override
	public int getLoc() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(Location l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRandom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teleport() {
		// TODO Auto-generated method stub
		
	}

}