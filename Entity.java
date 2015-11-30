
public class Entity {

	protected Location loc;
	protected Room currentRoom;

	public Entity(Room r, Location l) {
		currentRoom = r;
		setLocation(l);
	}

	public Entity(Room r) {
		this(r, r.getRandomEmptyLocation());
	}

	public void setLocation(Location newLoc) {
		int myNum = currentRoom.get(loc.getRow(), loc.getCol());
		if (this.loc != null)
			currentRoom.put(loc.getRow(), loc.getCol(), Game.EMPTY);

		this.loc = new Location(newLoc.getRow(), newLoc.getCol());
		currentRoom.put(this.loc.getRow(), this.loc.getCol(), myNum);
	}

	public Location getLoc() {
		return loc;
	}

	public void add(Location l) {
		
	}

	public void addRandom(){
		
	}
	
	public boolean move(int direction){
		Location moveTo = Location.locationInDirection(loc, direction);

		if (currentRoom.isEmpty(moveTo.getRow(), moveTo.getCol())) {
			currentRoom.moveElementAt(loc, direction);

			loc = moveTo; // update own location
			return true;
		}

		return false;
	}

}