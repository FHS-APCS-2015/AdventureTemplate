
public class Wall extends Entity{

	static String type = "X";
	public Wall(Room r, Location l) {
		super(r, l);
	}
	
	public String getDisplayString() {
		return type;
	}

}
