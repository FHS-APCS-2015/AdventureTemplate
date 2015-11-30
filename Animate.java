
public class Animate extends Entity {

	public Animate(Room r, Location l) {
		super(r, l);
	}

	public boolean move(int direction) {
		Location moveTo = Location.locationInDirection(getLocation(), direction);

		if (getRoom().isEmpty(moveTo.row, moveTo.col)) {
			getRoom().moveElementAt(getLocation(), direction);

			setLocation(moveTo); // update own location
			return true;
		}

		return false;
	}

	public void RandomMove() {
		for (int i = 0; i < 10000; i++) {
			int direction = (int) (Math.random() * 4);
			Location moveTo = Location.locationInDirection(getLocation(), direction);

			if (getRoom().isEmpty(moveTo.row, moveTo.col)) {
				getRoom().moveElementAt(getLocation(), direction);

				setLocation(moveTo); // update own location
			}
		}

	}

}
