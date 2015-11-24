/***
 * A player in the game.
 * 
 * @author David
 */
public class Player extends GameToken{

	public Player(Room r) {
		super(r, Game.PLAYER);
	}
	
	public Player(Room r, int row, int col){
		super(r, row, col, Game.PLAYER);
	}

	public void randomTeleport() {
		Location newLoc = currentRoom.getRandomEmptyLocation();
		currentRoom.moveObject(loc, newLoc);
		this.loc = newLoc;
	}
	
	public void attackWumpus(Wumpus wumpus){
		wumpus.randomMove();
	}
	
	public void loveWumpus(){
		
	}
	
}