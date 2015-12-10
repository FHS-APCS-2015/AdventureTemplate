
public class PopStar extends Enemy {

	
	public PopStar(Room r) {
		super(r);
		r.put(loc.row, loc.col, Game.POPSTAR);
	}
	
	public PopStar(Room r, Location loc) {
		super(r, loc);
		r.put(loc.row, loc.col, Game.POPSTAR);
	}

	public PopStar(Room r, Location loc, int gameVar) {
		super(r, loc, gameVar);
		r.put(loc.row, loc.col, Game.POPSTAR);
	}
	
	public PopStar(Room r, int gameVar) {
		super(r, gameVar);
		r.put(loc.row, loc.col, Game.POPSTAR);
	}

}
