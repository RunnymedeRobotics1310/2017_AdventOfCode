package day01.rem;

/**
 * The Path class extends the Position class so that we can
 * re-use the code that we generated for the position:
 * - move(String s) - parses the string and calls turn and moveForward
 * - turn(char turn) - turns to the specified direction
 *
 * The difference between Path and Position is that we now
 * have to track the Path, not just the ending 
 * position on the cityMap.  When tracking the path we 
 * create a cleared field, and then Override the 
 * moveForward(int distance) method to track every
 * step/block on the grid.
 *
 */
public class Path extends Position {

	// A cityMap size of 600x600 is just arbitrary... if there
	// is an indexOutOfBounds exception, then increase the 
	// size of the map by increasing the center.  A smaller
	// map is more viewable in the console.
	private static final int CENTER = 300;
	
	private int [][] cityMap = new int[CENTER*2][CENTER*2];
	
	private boolean crossingFound = false;
	private int crossingX = 0;
	private int crossingY = 0;
	
	/** Override the default constructor to add initialization logic */
	public Path() {

		// Initialize the starting point to the center of the field
		super.x = CENTER;
		super.y = CENTER;
		
		// initialize the starting point as having been visited 
		cityMap[super.x][super.y] = 1;
		
	}

	/** 
	 * Override the moveForward routine to mark the path on the cityMap
	 * instead of just calculating the end point.
	 */
	@Override
	public void moveForward(int distance) {
		
		// Move forward the number of blocks and update the map on each 
		// block moved.  Record the first crossing found.
		for (int i=0; i<distance; i++) {
			
			// Make a step in the facing direction
			switch (super.facing) {
			case 'N':   super.y ++;		break;
			case 'E':   super.x ++;   	break;
			case 'S':   super.y --;   	break;
			case 'W':   super.x --;   	break;
			default: break;
			}

			// Look for a crossing if one has not been found yet.
			if (!crossingFound) {
				
				if (cityMap[super.x][super.y] != 0) {
					crossingX     = super.x;
					crossingY     = super.y;
					crossingFound = true;
				}
			}
			
			// Continue updating the cityMap each block.
			cityMap[super.x][super.y] = 1;
		}
	}

	public int getCrossingDistance() {
		return Math.abs(crossingX-CENTER) + Math.abs(crossingY-CENTER);
	}
	
	/** 
	 * A fun routine that prints the path.  
	 * This is not a requirement of the puzzle. 
	 */
	public void printPath() {
		
		// Print the y rows inverted in order to have the 
		// map face in the natural direction (right side up with
		// North at the top).
		for (int y=cityMap.length-1; y>=0; y--) {

			for (int x=0; x<cityMap[y].length; x++) {
				
				// Look for an empty elements first.  
				// Most of the map will be empty
				// Print an unvisited point	
				if (cityMap[x][y] == 0) {
					System.out.print('.');
				
				// Print the starting point
				} else if (x == CENTER && y == CENTER) { 
					System.out.print("O");
				
				// Print the crossing
				} else if (x == crossingX && y == crossingY) { 
					System.out.print("X");
				
				// Print the end point
				} else if (x == super.x && y == super.y) { 
						System.out.print("Z");
					
				// Mark all points that were visited
				} else {
					System.out.print('*');
				}	

			}
			// Start a new row for each Y value North-South
			System.out.println();
		}
	}
}
