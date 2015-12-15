import javax.swing.JTextArea;

/***
 * Represents the entire game.
 * 
 * @author David
 */
public class Game {  
    public enum KeyAction {
        RIGHT, LEFT, UP, DOWN
    };
    
    // possible values for locations in a Room object
    static final int INVALID = -1;
    static final int EMPTY = 0;
    static final int PLAYER = 1;
    static final int WALL = 2;
    static final int WUMPUS = 3;
    
    private Room currentRoom;
    private Player player;
    private Wumpus enemy;
   
    private JTextArea display;

    public Game(JTextArea display) {
        this.display = display;
        currentRoom = new Room(60, 20);
        player = new Player(currentRoom);
        enemy = new Wumpus(currentRoom);
        
        displayWelcome();
    }

    /**
     * Performs the appropriate action in response to a keyboard press action.
     * 
     * @param the key that was pressed which we want to perform an action for.
     */
    public void handleEvent(KeyAction e) {
        if (e == KeyAction.RIGHT) {
            player.move(Location.EAST);
        }
        if (e == KeyAction.LEFT) {
            player.move(Location.WEST);
        }
        if (e == KeyAction.UP) {
            player.move(Location.NORTH);
        }
        if (e == KeyAction.DOWN) {
            player.move(Location.SOUTH);
        }
    }
    
    /**
     * Performs an action for a command typed at the game console.
     * 
     * @param cmd the string the user typed at the game console.
     */
    public void handleCommand(String cmd) {
        if (cmd.contains("look")) display("DON'T TOUCH THE WUMPUS!!");
        else if(cmd.contains("go left")) player.move(Location.WEST);
        else if(cmd.contains("go right")) player.move(Location.EAST);
        else if(cmd.contains("go up")) player.move(Location.NORTH);
        else if(cmd.contains("go down")) player.move(Location.SOUTH);
        else if(cmd.contains("escape")) player.moveToRandomDirection();
        else if(cmd.contains("attack") && currentRoom.areAdjacent(player, enemy)) display("pew pew");
        else if(cmd.contains("slide to the left")){
        	player.moveToTheWall(Location.WEST);
        	enemy.moveToRandomDirection();
        }
        else if(cmd.contains("slide to the right")){
        	player.moveToTheWall(Location.EAST);
        	enemy.moveToRandomDirection();
        }
        else if(cmd.contains("slide to the up")){
        	player.moveToTheWall(Location.NORTH);
        	enemy.moveToRandomDirection();
        }
        else if(cmd.contains("slide to the down")){
        	player.moveToTheWall(Location.SOUTH);
        	enemy.moveToRandomDirection();
        }
        else if(cmd.contains("everybody clap yo hands")){
        	int randRow = (int)(Math.random()*(currentRoom.getWidth() - 1));
        	int randCol = (int)(Math.random()*(currentRoom.getHeight() - 1));
        	currentRoom.put(enemy.getRow(), enemy.getCol(), Game.EMPTY);
        	currentRoom.put(randRow, randCol, Game.WUMPUS);
        }
        else
            display("I don't know what you mean...");
    }
    
    private void displayWelcome() {
        display.append("Welcome to our AMAZING TEXT ADVENTURE!\n");
        display.append("Use the arrow keys to navigate\n\n");
        display.append("Don't touch the wumpus");
    }
    
    public void display(String msg) {
        display.append(msg + "\n");
    }

	public Room getCurrentRoom() {
		return currentRoom;
	}
}