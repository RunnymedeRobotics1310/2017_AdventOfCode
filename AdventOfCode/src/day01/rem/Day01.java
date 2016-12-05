package day01.rem;

import java.util.Scanner;

/**
 * This class shows the general structure to the AdventOfCode 
 * solutions for 2017
 */
public class Day01 {

	private Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		(new Day01()).solve();
	}

	/**
	 * Solve the day's puzzle
	 */
	private void solve() {
		
		System.out.println("Paste puzzle input here...");
		
		Position position = new Position();
		Path     path     = new Path();
		
		while (true) {
			
			// Continue reading input lines until a blank line is encountered
			String s = input.nextLine();

			if (s.trim().isEmpty()) { break; }
			
			// Process each input line
			String [] moveStrings = s.split(", ");
			
			for (String moveString: moveStrings) {
				
				position.move(moveString);
				path    .move(moveString);
			}
			
		}
		
		// Print the solution(s)
		System.out.println("Distance: " + position.getDistance());
		System.out.println("Crossing: " + path.getCrossingDistance());
		
		// Print the path... in order for this to work properly, 
		// the console size must be set to 1,000,000 characters.
		// In eclipse Window->Preferences search for Console, and set the 
		// Console buffer size to 1000000.
		path.printPath();
	}
}
