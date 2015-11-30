/***
 * A player in the game.
 * 
 * @author David
 */
public class Player extends Animate {

	public Player(Room r, Location l) {
		super(r, l);
		setLocation(new Location(getRoom().getHeight() / 2, getRoom().getWidth() / 2));
		getRoom().put(getRow(), getCol(), Game.PLAYER);
	}

	public boolean isAdjacent(Wumpus enemy) {
		if (Math.abs(getCol() - enemy.getCol()) == 1 && Math.abs(getRow() - enemy.getRow()) == 0)
			return true;
		if (Math.abs(getRow() - enemy.getRow()) == 1 && Math.abs(getCol() - enemy.getCol()) == 0)
			return true;
		if (Math.abs(getRow() - enemy.getRow()) == 1 && Math.abs(getCol() - enemy.getCol()) == 1)
			return true;

		return false;

	}

}