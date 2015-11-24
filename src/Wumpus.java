/***
 * An enemy which can occupy a location in a room and is not to be touched.
 * 
 * @author David
 */
public class Wumpus extends Enemy{
    
    public Wumpus(Room r, Location l, Player p) {
        super(r, l, p);
        
    }
    
    // returns true if enemy was able to move in that direction.
    /*public boolean move(int direction) {
        int newrow = loc.row;
        int newcol = loc.col;
        
        if (direction == Location.NORTH) newrow--;
        if (direction == Location.SOUTH) newrow++;
        if (direction == Location.EAST) newcol++;
        if (direction == Location.WEST) newcol--;
        
        if (currentRoom.isEmpty(newrow, newcol)) {
            currentRoom.put(row, col, 0);
            currentRoom.put(newrow, newcol, 3);
            loc.setRow(newRow);
            loc.setCol(newCol);
            return true;
        }
       
        return false;
    }*/
  
}