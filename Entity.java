
public class Entity {
	private Location loc;
	private Room currentRoom;
	
	public Entity(Room r,Location loc){
		this.loc = loc;
		currentRoom = r;
	}
	
	public Location getLocation(){
		return loc;
	}
	public void setRoom(Room r){
		currentRoom = r;
	}
	public void setLocation(Location l){
		int num = 0;
		if(this.loc != null){
			num = currentRoom.get(loc.row, loc.col);
			currentRoom.put(this.loc.row, loc.col, Game.EMPTY);
		}
		this.loc = l;
		currentRoom.put(l.row, l.col, num);
	}
	
}
