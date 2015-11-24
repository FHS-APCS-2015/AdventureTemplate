/***
 * A player in the game.
 * 
 * @author David
 */
public class Player extends Animate{

	public Player(Room r) {
		super(r, Game.PLAYER);
	}
	
	public Player(Room r, Location loc){
		super(r, loc, Game.PLAYER);
	}

	
	public void attackWumpus(Wumpus wumpus){
		wumpus.randomMove();
	}
	
	public void loveWumpus(Wumpus parentWumpus){
		int direction = (int)(Math.random()*8);
		
	}
	
}