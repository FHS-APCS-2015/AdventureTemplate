
public class PopStar extends Enemy {

	static String type = "P";
	public PopStar(Room r, Location l, Player p) {
		super(r, l, p);
	}
	
	public String getDisplayString() {
		return type;
	}

}
