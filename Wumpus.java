/***
 * An enemy which can occupy a location in a room and is not to be touched.
 * 
 * @author David
 */
public class Wumpus extends Adversary {

	public Wumpus(Room r) {
		super(r,  Game.WUMPUS);
	}

	public Wumpus(Room r, Location loc) {
		super(r, loc, Game.WUMPUS);
	}

	
	
	public void chase (GameToken target){
		
	}

}