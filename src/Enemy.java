
public class Enemy extends Animate{
	Player player;
	int directionToPlayer;
	
	public Enemy(Room r, Location l, Player p) {
		super(r, l);
		player = p;
	}
	
	public void move(){
		
	}
	
	public int getDirectionToPlayer(){
    	return 0;
    }

}
