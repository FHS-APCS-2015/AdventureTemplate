
public abstract class Entity {
  Location loc;
  Room currentRoom;

  public Entity(Room r, Location l) {
    currentRoom = r;
    loc = l;
    setLocation(l);
    //currentRoom.put(loc.row, loc.col, this);
  }

  public Room getRoom() {
    return currentRoom;
  }

  public void setRoom(Room r) {
    currentRoom = r;
  }

  public Location getLocation() {
    return loc;
  }

  public int getRow() {
    return loc.getRow();
  }

  public int getCol() {
    return loc.getCol();
  }

  public void setLocation(Location newLoc) {
    // save yourself
    Entity t = currentRoom.get(loc.row, loc.col);
    
    if (newLoc == null) {
      // if you not empty, make your currentLoc empty
      if (this.loc != null) {
        currentRoom.put(this.loc.row, loc.col, null);
      }
  
      // if your newLoc is empty place yourself there (with the self you saved from before)
      
      currentRoom.put(newLoc.getRow(), newLoc.getCol(), t);
    }

    
  }

  public abstract String getDisplayString();

}
