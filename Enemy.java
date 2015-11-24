
public class Enemy extends Animate {
	Player currentPlayer;
	
	public Enemy(Room r) {
		super(r);
	}

	public Enemy(Room r, Location l) {
		super(r, l);
	}

	public Enemy(Room r, Location l, int gameVar) {
		super(r, l, gameVar);
	}

	public Enemy(Room r, int gameVar) {
		super(r, gameVar);
	}
	
	public Player getPlayer() {
		return currentPlayer;
	}
	
	public void setPlayer(Player p) {
		currentPlayer = p;
	}
}
