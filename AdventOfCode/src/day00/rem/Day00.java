package day00.rem;

import java.util.Scanner;

public class Day00 {

	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		(new Day00()).solve();
	}

	private void solve() {
		
		System.out.println("Paste puzzle input here...");
		
		while (true) {
			
			// Continue reading input lines until a blank line is encountered
			String s = input.nextLine();

			if (s.trim().isEmpty()) { break; }
			
			// Process each input line
		
		}
		
		// Print the solution
		System.out.println("Solution");
	}
}
