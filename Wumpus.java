/***
 * An enemy which can occupy a location in a room and is not to be touched.
 * 
 * @author David
 */
public class Wumpus{
    private Room currentRoom;		// room the Wumpus is in
    private int row, col;			// the location of the wumpus in the room
    Location loc;
    
    public Wumpus(Room r) {
        currentRoom = r;      
        row = 6;
        col = 8;
        currentRoom.put(row, col, 3);			// THIS IS BAD.  WHY?
        loc = new Location(row, col);
    }
    
    // returns true if enemy was able to move in that direction.
    public boolean move(int direction) {
        int newrow = row;
        int newcol = col;
        
        if (direction == Location.NORTH) newrow--;
        if (direction == Location.SOUTH) newrow++;
        if (direction == Location.EAST) newcol++;
        if (direction == Location.WEST) newcol--;
        
        if (currentRoom.isEmpty(newrow, newcol)) {
            currentRoom.put(row, col, 0);
            currentRoom.put(newrow, newcol, 3);
            row = newrow;
            col = newcol;
            return true;
        }
        
        return false;
    }
    
    public int getDirectionToPlayer(){
    	
    }
    
    public boolean moveTowardsPlayer(){
    	Location player = currentRoom.getPlayerLocation();
    	int pRow = player.getRow();
    	int pCol = player.getCol();
    	int d = getDirectionToPlayer();
    	move(d);
    }
    
    public boolean moveAwayFromPlayer(){
    	
    }
    
    
    
    public void moveToRandomDirection(){
    	for(int i = 0; i < 10000; i ++){
    		int rand = (int)(Math.random() *4);
    		move(rand);
    	}
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