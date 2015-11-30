
public class Enemy extends Animate {
	private int moveUp;

	public Enemy(Room r, Location l) {
		super(r, l);
		moveUp = 1;
	}

	public void moveUpAndDown() {
		Location loc = new Location(getRow(), getCol());
		int direction;

		if (moveUp == 1)
			direction = 0;
		else
			direction = 2;

		Location moveTo = Location.locationInDirection(loc, direction);

		boolean something = move(direction);

		if (!something)
			moveUp = moveUp * -1;

	}

	public void runTowards(Player player) {
		if (player.getRow() > getRow())
			move(Location.SOUTH);
		if (player.getRow() < getRow())
			move(Location.NORTH);
		if (player.getCol() > getCol())
			move(Location.EAST);
		if (player.getCol() < getCol())
			move(Location.WEST);
	}

	public void doNothing() {
		System.out.println("doing nothing");

	}

	public void makeMove(Player player) {
		double distance = Math.sqrt((getRow() - player.getRow()) * (getRow() - player.getRow())
				+ (getCol() - player.getCol()) * (getCol() - player.getCol()));

		if (distance > 20)
			doNothing();
		if (distance < 20 && distance > 10)
			moveUpAndDown();
		if (distance < 10 && distance > 5)
			RandomMove();
		if (distance < 5)
			runTowards(player);

	}

}
