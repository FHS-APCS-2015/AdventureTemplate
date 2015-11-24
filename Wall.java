
public class Wall extends GameToken{
	
	public Wall(Room r, int type){
		super(r, type);
	}
	
	public Wall(Room r, Location loc, int type){
		super(r, loc, type);
	}
	
}
