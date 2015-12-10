
public abstract class Entity {
	Location loc;
	Room currentRoom;
	

	public Entity(Room r) {
		currentRoom = r;
		loc = r.getRandomLocation();
		
	}

	public Entity(Room r, Location l) {
		currentRoom = r;
		loc = l;
	}
	public Entity(Room r, Location l, int gameVar) {
		currentRoom = r;
		loc = l;
	}
	public Entity(Room r, int gameVar) {
		currentRoom = r;
		loc = r.getRandomLocation();
	}
	/*
	public Entity(){
	}*/

	public Room getRoom() {
		return currentRoom;
	}

	public void setRoom(Room r) {
		currentRoom = r;
	}

	public Location getLocation() {
		return loc;
	}
	
	public void setLocation(Location loc) {
		if(this.loc!=null)
			currentRoom.put(this.loc.row, this.loc.col, Game.EMPTY);
			
		this.loc = new Location(loc.row, loc.col);
		currentRoom.put(loc.row, loc.col, currentRoom.get(this.loc.row, this.loc.col));
	}

}
