/***
 * A player in the game.
 * 
 * @author David
 */
public class Player extends Animate {
	static String type = "*";
	
    public Player(Room r, Location l) {
        super(r, l);
    }
   
   
    
    public void moveToTheWall(int d) { 
    	int oldr = getRow();
		int oldc = getCol();
    	if(d == Location.WEST){
    		currentRoom.put(getRow(), 1, this);
    		loc = new Location(getRow(), 1);
    		currentRoom.put(oldr, oldc, null);
    		
    	}
    	if(d == Location.EAST){
    		currentRoom.put(getRow(), currentRoom.getWidth() - 2, this);
    		loc = new Location(getRow(), currentRoom.getWidth() - 2);
    		currentRoom.put(oldr, oldc, null);
    	}
    	if(d == Location.NORTH){
    		currentRoom.put(1, getCol(), this);
    		loc = new Location(1, getCol());
    		currentRoom.put(oldr, oldc, null);
    	}
    	if(d == Location.SOUTH){
    		currentRoom.put(getRow(), currentRoom.getHeight() - 2, this);
    		loc = new Location(getRow(), currentRoom.getHeight() - 2);
    		currentRoom.put(oldr, oldc, null);
    	}
    }
    
    public String getDisplayString(){
    	return type;
    }
    
    public String toString(){
		return type;
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