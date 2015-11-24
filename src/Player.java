/***
 * A player in the game.
 * 
 * @author David
 */
public class Player extends Animate {
    
    public Player(Room r, Location l) {
        super(r, l);
        loc = new Location(currentRoom.getHeight()/2, currentRoom.getWidth()/2);
        currentRoom.put(loc.row, loc.col, Game.PLAYER);
    }
    
    // returns true if player was able to move in that direction.
   /* public boolean move(int direction) {
        Location moveTo = Location.locationInDirection(loc, direction);
        
        if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
            currentRoom.moveElementAt(loc, direction);

            loc = moveTo;   // update own location
            return true;
        }
        
        return false;
    }*/
    
   
    
    public void moveToTheWall(int d) { 
    	int oldr = getRow();
		int oldc = getCol();
    	if(d == Location.WEST){
    		currentRoom.put(getRow(), 1, Game.PLAYER);
    		loc = new Location(getRow(), 1);
    		currentRoom.put(oldr, oldc, Game.EMPTY);
    		
    	}
    	if(d == Location.EAST){
    		currentRoom.put(getRow(), currentRoom.getWidth() - 2, Game.PLAYER);
    		loc = new Location(getRow(), currentRoom.getWidth() - 2);
    		currentRoom.put(oldr, oldc, Game.EMPTY);
    	}
    	if(d == Location.NORTH){
    		currentRoom.put(1, getCol(), Game.PLAYER);
    		loc = new Location(1, getCol());
    		currentRoom.put(oldr, oldc, Game.EMPTY);
    	}
    	if(d == Location.SOUTH){
    		currentRoom.put(getRow(), currentRoom.getHeight() - 2, Game.PLAYER);
    		loc = new Location(getRow(), currentRoom.getHeight() - 2);
    		currentRoom.put(oldr, oldc, Game.EMPTY);
    	}
    }
    
    public void updateLoc(int row, int col){
    	
    }
    
    public Location getLocation(){
    	return loc;
    }
    
    public int getRow(){
    	return loc.row;
    }
    
    public int getCol(){
    	return loc.col;
    }
    
}