package day02.rem;

public class KeyPad {
	
	private int [][] keyPad = { { 1, 2, 3 },
								{ 4, 5, 6 },
								{ 7, 8, 9 } };
	
	private int x = 1;
	private int y = 1;
	
	public int getNextKey(String instructionString) {
		
		char [] instructions = instructionString.toCharArray();
		
		for (char instruction: instructions) {
			
			switch(instruction) {
			
			case 'U':
				y--;
				if (y < 0) { y = 0; }
				break;
			
			case 'D':
				y++;
				if (y > 2) { y = 2; }
				break;
			
			case 'L':
				x--;
				if (x < 0) { x = 0; }
				break;

			case 'R':
				x++;
				if (x > 2) { x = 2; }
				break;
			}
		}
		
		// Careful to return the correct key at the end.
		// Y is the first dimension in the keypad array.
		return keyPad[y][x];
	}
	
}
