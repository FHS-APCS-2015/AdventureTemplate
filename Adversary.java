
public class Adversary extends Animate{
	Player p;
	
	public Adversary(Room r, int type){
		super(r, type);
	}
	
	public Adversary(Room r, Location l, int type){
		super(r, l, type);
	}
	
	public Player getPlayer(){
		return p;
	}
	

}
