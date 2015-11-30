
public class Enemy implements Animate {

	public void move(Location L) {

	}

	public void move(int n) {

	}

	public void teleport() {

	}

	public int getLoc() {

	}

	public void add(Location l) {

	}

	public void addRandom() {

	}
	
	public void go (){ 
		
	}
	
	public void run(){
		
	}

	public boolean checkMove(){
		Location moveTo = Location.locationInDirection(loc, direction);

		if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
			currentRoom.moveElementAt(loc, direction);

			loc = moveTo; // update own location
			return true;
		}

		return false;
	}
}
