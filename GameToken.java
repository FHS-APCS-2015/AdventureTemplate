
public class GameToken {
	protected Room currentRoom;
	protected Location loc;

	public GameToken(Room r, int tokenType) {
		currentRoom = r;
		loc = currentRoom.getRandomEmptyLocation();
		currentRoom.put(loc.row, loc.col, tokenType);
	}
	public GameToken(Room r, Location l, int tokenType) {
		currentRoom = r;
		loc = l;
		currentRoom.put(loc.row, loc.col, tokenType);
	}
	
	/*
	 * Gives the distance between two different GameTokens 
	 * @Param observed distance to this object
	 * @Return a int[] containing the row distance and col distance
	 */
	public int[] getDistanceTo(GameToken observed){
		int distanceRow = Math.abs(this.loc.row - observed.loc.row);
		int distanceCol = Math.abs(this.loc.col - observed.loc.col);
		int [] distance = new int[] {distanceRow, distanceCol};
		return distance;
	}
	
	
	/*
	 * Answers whether or not two GameTokens are adjacent
	 * @Param observed the GameToken to check adjacency
	 * @Return if the tokens are adjacent return true
	 */
	public boolean isAdjacent(GameToken observed){
		int [] distance = getDistanceTo(observed);
		if(distance[0] < 2 && distance[1] < 2)
			return true;
		return false;
	}
	
	public void setLocation(Location newLoc){
		int tokenType = 0;
		if(loc != null){
			tokenType = currentRoom.get(loc.row, loc.col);
			currentRoom.put(loc.row, loc.col, Game.EMPTY);
		}
		currentRoom.put(newLoc.row, newLoc.col, tokenType);
		this.loc = newLoc;
		
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
