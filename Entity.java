
public class Entity {
	private Room currentRoom;
	private Location loc;

	public Entity(Room r, Location l) {
		currentRoom = r;
		loc = l;
	}

	public int getRow() {
		return loc.row;
	}

	public int getCol() {
		return loc.col;
	}

	public Room getRoom() {
		return currentRoom;
	}

	public Location getLocation() {
		return loc;
	}

	public void setLocation(Location newLoc) {
		int saveValue = currentRoom.get(getRow(), getCol());
		;
		if (this.loc != null) {
			currentRoom.put(getRow(), getCol(), Game.EMPTY);
		}
		loc = new Location(newLoc.row, newLoc.col);
		currentRoom.put(loc.row, loc.col, saveValue);
	}

}
