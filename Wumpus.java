/***
 * An enemy which can occupy a location in a room and is not to be touched.
 * 
 * @author David
 */
public class Wumpus extends GameToken {
	private final static int startingRow = 8;
	private final static int startingCol = 12;

	public Wumpus(Room r) {
		super(r, startingRow, startingCol, Game.WUMPUS);
	}

	public Wumpus(Room r, int row, int col) {
		super(r, row, col, Game.WUMPUS);
	}

	public void randomMove() {
		boolean moved = false;
		do {
			moved = move(currentRoom.getRandomDirection());
		} while (moved == false);
	}
	
	public void chase (GameToken target){
		
	}

}