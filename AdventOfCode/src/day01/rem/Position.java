package day01.rem;

public class Position {

	// Initialize the starting position
	protected int x = 0;
	protected int y = 0;
	protected char facing = 'N';
	
	/** Get the distance from the start **/
	public int getDistance() {
		return Math.abs(x) + Math.abs(y);
	}

	public void move(String instruction) {
		
		char turn = instruction.charAt(0);
		int distance = Integer.valueOf(instruction.substring(1));
		
		turn(turn);
		moveForward(distance);
		
	}
	
	/** Move forward in the facing direction */
	public void moveForward(int distance) {
		
		// Move forward the number of steps
		switch (facing) {
		case 'N':   y += distance; 	 break;
		case 'E':   x += distance;   break;
		case 'S':   y -= distance;   break;
		case 'W':   x -= distance;   break;
		default: break;
		}
		
	}
	
	/** Turn to face the new direction */
	public void turn(char turn) {
		
		switch (turn) {
		
		case 'L':
			switch (facing) {
			case 'N':   facing = 'W';   break;
			case 'E':   facing = 'N';   break;
			case 'S':   facing = 'E';   break;
			case 'W':   facing = 'S';   break;
			default: break;
			}
			break;

		case 'R':
			switch (facing) {
			case 'N':   facing = 'E';   break;
			case 'E':   facing = 'S';   break;
			case 'S':   facing = 'W';   break;
			case 'W':   facing = 'N';   break;
			default: break;
			}
			break;
			
		default:
			System.out.println("Unknown turn direction " + turn);
		}
	}
}
