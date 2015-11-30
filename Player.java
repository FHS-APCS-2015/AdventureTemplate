/***
 * A player in the game.
 * 
 * @author David
 */
public class Player {
    private Room currentRoom;				// room player is in
    private Location loc;					// location of the player in the room
    
    public Player(Room r) {
        currentRoom = r;
        setLoc(new Location(currentRoom.getHeight()/2, currentRoom.getWidth()/2));
        currentRoom.put(getLoc().row, getLoc().col, Game.PLAYER);
    }
    
    // returns true if player was able to move in that direction.
    public boolean move(int direction) {
        Location moveTo = Location.locationInDirection(getLoc(), direction);
        
        if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
            currentRoom.moveElementAt(getLoc(), direction);

            setLoc(moveTo);   // update own location
            return true;
        }
        
        return false;
    }

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public void teleport() {
		Location newLoc = currentRoom.getRandomLocation();
		
		currentRoom.moveEntity(loc, newLoc);
		this.loc = newLoc;
		
	}
	public void attack(){
		if(currentRoom.searchAdjacent(loc) == Game.WUMPUS){
			
		}
		
	}
}