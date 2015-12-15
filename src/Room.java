/***
 * A room in the game. A room contains a 2d int array to represent the things in
 * the room. See the Game class for int constants that represent different game
 * things. For example: Game.WUMPUS = 3; These are the values in the room int
 * array.
 * 
 * @author David
 */
public class Room {
	private Entity[][] room; 					// 2d array of Entities for the room
	private static String[] displaySymbols = { ".", "*", "X", "W" };
	private int width, height;
	private String longDescription;
	private String shortDescription;

	public Room(int w, int h) {
		width = w;
		height = h;
		room = new Entity[h][w];
		addBorder();
	}

	// Adds a border of wall objects around the edges of the room
	private void addBorder() {
	  //left wall
	  for(int i = 0; i < room.length; i ++){
	    Location l = new Location(i, 0);
	    room[i][0] = new Wall(this, l);
	  }
	  
	  //right wall
    for(int i = 0; i < room.length; i ++){
      Location l = new Location(i, (room[0].length - 1));
      room[i][room[0].length - 1] = new Wall(this, l);
    }
	  
    //top wall
    for(int i = 0; i < room[0].length; i ++){
      Location l = new Location(0, i);
      room[0][i] = new Wall(this, l);
    }
    
    //bottom wall
    for(int i = 0; i < room[0].length; i ++){
      Location l = new Location(room.length - 1, i);
      room[room.length - 1][i] = new Wall(this, l);
    }
	  
	}

	/**
	 * Returns the value of (row, col) in the room.  Possible values include
	 * Game.WUMPUS, Game.WALL, Game.PLAYER, Game.EMPTY, Game.INVALID
	 * 
	 * @param row the row in the room grid
	 * @param col the column in the room grid
	 * @return what is at that location in the room.
	 */
	public Entity get(int row, int col) {
		if (isInRoom(row, col)) {
			return room[row][col];
		}
		return null;
	}
	
	public Location getWumpusLocation(){
		Location n = new Location(0, 0);
		
		for(int row = 0; row < width; row ++){
			for(int col = 0; col < height; col ++){
				Location l = new Location(row, col);
				if(get(row, col) instanceof Wumpus) return l;
			}
		}
		
		return n;
	}
	
	public Location getPlayerLocation(){
		Location n = new Location(0, 0);
		
		for(int row = 0; row < width; row ++){
			for(int col = 0; col < height; col ++){
				Location l = new Location(row, col);
				if(get(row, col) instanceof Player) return l;
			}
		}
		
		return n;
		
	}

	/**
	 * Put a new value into the room grid at (row, col).  Possible values include
	 * Game.WUMPUS, Game.WALL, Game.PLAYER, Game.EMPTY
	 * 
	 * @param row the row to place the new value 
	 * @param col the column to place the new value
	 * @param value the value to be placed at (row, col)
	 */
	public void put(int row, int col, Entity t) {
		if (isInRoom(row, col) && room[row][col] == null)
			room[row][col] = t;
	}

	/**
	 * Return a string representation for the room.  This is what actually
	 * gets displayed by the GUI class and what the user sees.
	 */
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int r = 0; r < room.length; r++) {
			for (int c = 0; c < room[0].length; c++) {
				Entity e = room[r][c];
				//System.out.println(e);
				if(e == null) b.append(" ");
				else
					b.append(e.getDisplayString());
			}
			b.append("\n");
		}
		return b.toString();
	}

	int getWidth() {
		return room[0].length;
	}

	int getHeight() {
		return room.length;
	}

	// return true if (newrow, newcol) is Game.EMPTY
	boolean isEmpty(int newrow, int newcol) {
		return get(newrow, newcol) == null;
	}

	// return true if Location loc is Game.EMPTY
	boolean isEmpty(Location loc) {
		return isEmpty(loc.row, loc.col);
	}

	// Move the element at Location loc in the direction
	// This places the element at the new location and sets
	// the previous location to Game.EMPTY
	void moveElementAt(Location loc, int direction) {
		if (!isInRoom(loc))
			return;

		Location moveTo = Location.locationInDirection(loc, direction);

		if (!isInRoom(moveTo))
			return;

		room[moveTo.row][moveTo.col] = room[loc.row][loc.col]; // move thing
		room[loc.row][loc.col] = null; // old square empty
	}
	
	

	// return true if (row, col) is a valid location in the room
	public boolean isInRoom(int row, int col) {
		if (row < 0 || col < 0) {
			return false;
		}
		if (row >= room.length) {
			return false;
		}
		if (col >= room[0].length) {
			return false;
		}
		return true;
	}

	public boolean isInRoom(Location loc) {
		return isInRoom(loc.row, loc.col);
	}

	// return a random location in the room
	public Location getRandomLocation() {
		return new Location((int) (Math.random() * height),
				(int) (Math.random() * width));
	}
	
	public boolean areAdjacent(Player p, Wumpus w){
		
		if((w.loc.getRow() - p.loc.getRow()) == 0 || (w.loc.getCol() - p.loc.getCol()) == 0) {
			if( Math.abs(w.loc.getRow() - p.getRow()) == 4 || Math.abs(w.loc.getCol() - p.getCol()) == 4) {
				return true;
			}
		}
		
		return false;
	}
}