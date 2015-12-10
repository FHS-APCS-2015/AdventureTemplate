
public class Wall extends Entity{
	
	public Wall(Room r){
		super(r);
	}
	
	public Wall(Room r, Location l){
		super(r, l);
		r.put(loc.row, loc.col, Game.WALL);
	}

	@Override
	public String toString() {
		return "X";
	}
	

}
