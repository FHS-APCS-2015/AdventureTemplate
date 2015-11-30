
public class Entity {
	Location loc;
	Room currentRoom;
	
	

	public Entity(Room r, Location l) {
		currentRoom = r;
	}
	
	public Room getRoom(){
		return currentRoom;
	}
	
	public void setRoom(Room r){
		currentRoom = r;
	}
	
	public Location getLocation(){
		return loc;
	}
	
	//TODO: fix constructor bug
	public void setLocation(Location newLoc){
		int MYNUM = currentRoom.get(loc.row, loc.col);
		
		if(this.loc != null){
			currentRoom.put(this.loc.row, loc.col, Game.EMPTY);
		}
		
		this.loc = new Location(newLoc.row, newLoc.col);
		currentRoom.put(loc.row, loc.col, MYNUM);
	}
	
	

}
