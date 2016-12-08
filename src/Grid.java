import java.util.Scanner;

public class Grid {
	Ship[] shipList;
	char hitShip = 'H';
	char missShip = 'M';
	char alreadyShot = '*';
	char shotShip = 'X';
	boolean[][] moves = new boolean[10][10];
	char[][] board = new char[10][10];

	Grid() {
		// Make Ships
		Ship[] tmpShipList = { new Ship(2), new Ship(3), new Ship(3),
				new Ship(4), new Ship(5) };
		shipList = tmpShipList;
	}

	public void printPlayerGrid() {

		// Printing Top Labels
		char labels = 'A';
		System.out.print("  ");
		for (int i = 0; i < board.length; i++) {
			System.out.print(labels + " ");
			labels++;
		}
		System.out.println();

		// Printing rest of the Grid
		int label = 1;
		for (int r = 0; r < board.length; r++) {
			if (r >= 9) {
				System.out.print(label);
			} else {
				System.out.print(label + " ");
				label++;
			}
			for (int c = 0; c < board.length; c++) {
				board[r][c] = '~';
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}

		System.out
				.println("+--------------------------+\n     1.S-S                  \n     2.S-S-S                \n"
						+ "     3.S-S-S                \n     4.S-S-S-S              \n     5.S-S-S-S-S            \n"
						+ " PLAYER: PLACE YOUR SHIPS   \n+--------------------------+");

	}

	public void setShipInfo() {
		Scanner keyb = new Scanner(System.in);
		for (int shipNum = 0; shipNum < shipList.length; shipNum++) {
			System.out.print("You will be placing ship #" + (shipNum + 1)
					+ " (");
			for (int i = 0; i < shipList[shipNum].size; i++) {
				if (i == shipList[shipNum].size - 1) {
					System.out.print("S)");
				} else {
					System.out.print("S-");
				}
			}
			System.out.println();
			// Choose Vertical or Horizontal
			String verticalInput = "";
			do {
				System.out
						.println("do you want to place the ship horizontally or vertically? (H/V)");
				verticalInput = keyb.nextLine();
			} while (!verticalInput.equalsIgnoreCase("H")
					&& !verticalInput.equalsIgnoreCase("V"));
			if (verticalInput.equalsIgnoreCase("V")) {
				shipList[shipNum].isVertical = true;
			} else {
				shipList[shipNum].isVertical = false;
			}
			// Choose Coordinates
			String userInput = "";
			char rowInput;
			int colInput = 0;
			do {
				System.out
						.println("What row and column do you want to place your ship?");
				userInput = keyb.nextLine().trim();
				rowInput = Character.toUpperCase(userInput.charAt(0));
				colInput = Integer.parseInt(userInput.substring(1));
			} while (userInput.length() > 3);
			shipList[shipNum].row = rowInput - 65;
			shipList[shipNum].col = colInput - 1;
			System.out.println("the ship " + shipList[shipNum] + "'s row is "
					+ shipList[shipNum].row + " and the column is "
					+ shipList[shipNum].col
					+ " and the ship's boolean isVertical is "
					+ shipList[shipNum].isVertical);
		}
	}

	public void printGridWithShips() {
		// Printing Top Labels
		char charLabel = 'A';
		System.out.print("  ");
		for (int i = 0; i < board.length; i++) {
			System.out.print(charLabel + " ");
			charLabel++;
		}
		System.out.println();

		// Printing rest of the Grid
		int numLabel = 1;
		for (int r = 0; r < board.length; r++) {
			if (r >= 9) {
				System.out.print(numLabel);
			} else {
				System.out.print(numLabel + " ");
				numLabel++;
			}
			for (int c = 0; c < board.length; c++) {
				// TODO figure out how to place ships
				System.out.print(board[r][c] + " ");
				
			}
			System.out.println();
		}
	}
}
