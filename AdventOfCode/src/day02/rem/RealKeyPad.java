package day02.rem;

public class RealKeyPad {
	
	private char [][] keyPad = { { ' ', ' ', '1', ' ', ' ' },
						 		 { ' ', '2', '3', '4', ' ' },
								 { '5', '6', '7', '8', '9' },
								 { ' ', 'A', 'B', 'C', ' ' },
								 { ' ', ' ', 'D', ' ', ' ' } } ;
	
	private int x = 0;
	private int y = 2;
	
	public char getNextKey(String instructionString) {
		
		char [] instructions = instructionString.toCharArray();
		
		for (char instruction: instructions) {
			
			switch(instruction) {
			
			case 'U':
				if (y == 0)                { break; }
				if (keyPad[y-1][x] == ' ') { break; }
				y--;
				break;
			
			case 'D':
				if (y == 4)                { break; }
				if (keyPad[y+1][x] == ' ') { break; }
				y++;
				break;
				
			case 'L':
				if (x == 0)                { break; }
				if (keyPad[y][x-1] == ' ') { break; }
				x--;
				break;

			case 'R':
				if (x == 4)                { break; }
				if (keyPad[y][x+1] == ' ') { break; }
				x++;
				break;
			}
		}
		
		// Careful to return the correct key at the end.
		// Y is the first dimension in the keypad array.
		return keyPad[y][x];
	}
	
}
