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
    static final int POPSTAR = 4;
    
    private Room currentRoom;
    private Player player;
    private Wumpus enemy;
    private PopStar popstar;
   
    private JTextArea display;

    public Game(JTextArea display) {
        this.display = display;
        currentRoom = new Room(60, 20);
        player = new Player(currentRoom);
        enemy = new Wumpus(currentRoom);
        popstar = new PopStar(currentRoom);
        
        displayWelcome();
    }

    /**
     * Performs the appropriate action in response to a keyboard press action.
     * 
     * @param the key that was pressed which we want to perform an action for.
     */
    public void handleEvent(KeyAction e) {
        if (e == KeyAction.RIGHT) {
        	System.out.println("right is pressed");
            player.move(Location.EAST);
        }
        if (e == KeyAction.LEFT) {
        	System.out.println("left is pressed");
            player.move(Location.WEST);
        }
        if (e == KeyAction.UP) {
        	System.out.println("north is pressed");
            player.move(Location.NORTH);
        }
        if (e == KeyAction.DOWN) {
        	System.out.println("south is pressed");
            player.move(Location.SOUTH);
        }
    }
    
    /**
     * Performs an action for a command typed at the game console.
     * 
     * @param cmd the string the user typed at the game console.
     */
    public void handleCommand(String cmd) {
        if (cmd.contains("look")){
        	display("DON'T TOUCH THE WUMPUS!!");
        	enemy.flash();
        }
        else if(cmd.contains("go left")) handleEvent(Game.KeyAction.LEFT);
        else if(cmd.contains("go right")) handleEvent(Game.KeyAction.RIGHT);
        else if(cmd.contains("go up")) handleEvent(Game.KeyAction.UP);
        else if(cmd.contains("go down")) handleEvent(Game.KeyAction.DOWN);
        else if(cmd.contains("run")) {
        
        }
        else if(cmd.contains("escape")) {
        	player.escape(); 
        	enemy.randomMove();
        }
        else if(cmd.contains("attack")) {
        	if(currentRoom.areAdjacent(player, enemy)) {
        			enemy.disappear();
        			display("ATTACK SUCCESSFUL!!!!");  
        	}
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