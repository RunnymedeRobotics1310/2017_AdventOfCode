package day03.rem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class shows the general structure to the AdventOfCode 
 * solutions for 2017
 */
public class Day03 {

	private Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		(new Day03()).solve();
	}

	/**
	 * Solve the day's puzzle
	 */
	private void solve() {

		List<Integer> sides = new ArrayList<Integer>(10000);
		
		System.out.println("Paste puzzle input here...");
		
		while (true) {
			
			// Continue reading input lines until a blank line is encountered
			String s = input.nextLine();

			if (s.trim().isEmpty()) { break; }
			
			// Process each input line
			addSides(s, sides);
		}
		
		// Print the solution
		System.out.println("Real Triangle Count " + getTriangleCount(sides));
		System.out.println("Listed Triangle Count " + getListedTriangleCount(sides));
	}
	
	private void addSides(String s, List<Integer> sides) {
		Scanner scanner = new Scanner(s);
		for (int i=0; i<3; i++) {
			sides.add(scanner.nextInt());
		}
		scanner.close();
	}

	private int getTriangleCount(List<Integer> sides) {
		
		int triangleCount = 0;
		
		for (int i=0; i<sides.size(); i+=3) {
			if (isValidTriangle(sides.get(i), sides.get(i+1), sides.get(i+2))) {
				triangleCount++;
			}
		}
		
		return triangleCount;
	}
	
	// Check the triangles in columns
	private int getListedTriangleCount(List<Integer> sides) {
		
		int triangleCount = 0;
		
		for (int i=0; i<sides.size(); i+=9) {
			for (int j=0; j<3; j++) {
				if (isValidTriangle(sides.get(i+j), sides.get(i+j+3), sides.get(i+j+6))) {
					triangleCount++;
				}
			}
		}
		
		return triangleCount;
	}

	// The triangle is valid if the largest side is less than
	// half of the total peremeter (a+b>c)
	// or a+b+c > 2*maxSide
	
	private boolean isValidTriangle(int a, int b, int c) {
		
		int max = max(a,b,c);
		
		return (a+b+c > 2*max);
	}
	
	private int max(int a, int b, int c) {
		
		if (a >= b && a >= c) { return a; }
		
		if (b >= c) { return b; }
		
		return c;
	}
}
