import java.util.Random;
import java.util.Scanner;

/**
 * this class prints the Grids of the Player and opponent
 * 
 * @author Jacky Zhou
 * @lastedited 2016-12-15
 */

public class Grid {
	Ship[] shipList;
	char hitShip = 'H';
	char missShip = 'M';
	char alreadyShot = '*';
	char shotShip = 'X';
	boolean[][] moves = new boolean[10][10];
	boolean[][] shipLocation = new boolean[10][10];
	char[][] board = new char[10][10];

	Grid() {
		// Make Ships
		Ship[] tmpShipList = { new Ship(2), new Ship(3), new Ship(3),
				new Ship(4), new Ship(5) };
		shipList = tmpShipList;
	}

	/**
	 * this method prints the Player's starting grid so that they can place the
	 * ships
	 */
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

	/**
	 * this method gets the ship info from the Player and is responsible for
	 * setting the variables of all the ships
	 */
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
			char colInput;
			int rowInput = 0;
			while (true) {
				try {
					System.out
							.println("What column and row do you want to place your ship?");
					userInput = keyb.nextLine().trim();
					colInput = Character.toUpperCase(userInput.charAt(0));
					rowInput = Integer.parseInt(userInput.substring(1));
					shipList[shipNum].col = colInput - 65;
					shipList[shipNum].row = rowInput - 1;
					Grid.this.printGridWithShips(shipList, shipNum);
					break;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("INVALID PLACEMENT!");
				}
			}

		}
	}

	/**
	 * this method prints out the grid with the ship placed on the board
	 * @param shipList Ship [](the array of ships to be placed)
	 * @param shipNum int (the index of the ship being placed)
	 */

	public void printGridWithShips(Ship[] shipList, int shipNum) {
		// Set the Grid
		shipLocation[shipList[shipNum].row][shipList[shipNum].col] = true;
		for (int shipSize = 1; shipSize < shipList[shipNum].size; shipSize++) {
			if (shipList[shipNum].isVertical == true) {
				shipLocation[shipList[shipNum].row + shipSize][shipList[shipNum].col] = true;
			} else {
				shipLocation[shipList[shipNum].row][shipList[shipNum].col
						+ shipSize] = true;
			}
		}
		//TODO fix printing out invalid entries
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
				if (shipLocation[r][c] == true) {
					System.out.print('S' + " ");
				} else {
					System.out.print('~' + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * this method sets the computer's ship info
	 */
	public void setOpponentShipInfo() {
		// TODO place computer's ships
		Random rng = new Random();
		for (int shipNum = 0; shipNum < shipList.length; shipNum++) {
			if (rng.nextInt() < 0.5) {
				shipList[shipNum].isVertical = true;
			} else {
				shipList[shipNum].isVertical = false;
			}

		}
	}
}
