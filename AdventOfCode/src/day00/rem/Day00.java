package day00.rem;

import java.util.Scanner;

/**
 * This class shows the general structure to the AdventOfCode 
 * solutions for 2017
 */
public class Day00 {

	private Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		(new Day00()).solve();
	}

	/**
	 * Solve the day's puzzle
	 */
	private void solve() {
		
		System.out.println("Paste puzzle input here...");
		
		while (true) {
			
			// Continue reading input lines until a blank line is encountered
			String s = input.nextLine();

			if (s.trim().isEmpty()) { break; }
			
			// Process each input line
			// ... insert solution code here
		}
		
		// Print the solution
		System.out.println("Solution");
	}
}
