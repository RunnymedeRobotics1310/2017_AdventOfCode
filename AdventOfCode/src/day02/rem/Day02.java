package day02.rem;

import java.util.Scanner;

/**
 * This class shows the general structure to the AdventOfCode 
 * solutions for 2017
 */
public class Day02 {

	private Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		(new Day02()).solve();
	}

	/**
	 * Solve the day's puzzle
	 */
	private void solve() {
		
		System.out.println("Paste puzzle input here...");
		
		KeyPad     keyPad     = new KeyPad();
		RealKeyPad realKeyPad = new RealKeyPad();
		
		String combination     = "";
		String realCombination = "";
		
		while (true) {
			
			// Continue reading input lines until a blank line is encountered
			String s = input.nextLine();

			if (s.trim().isEmpty()) { break; }
			
			// Process each input line
			combination     += keyPad    .getNextKey(s);
			realCombination += realKeyPad.getNextKey(s);
		}
		
		// Print the solution
		System.out.println("Combination      " + combination);
		System.out.println("Real Combination " + realCombination);
	}
}
