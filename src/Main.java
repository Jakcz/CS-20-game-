import java.util.Scanner;

/**
 * this class runs the game 
 * @author 499072002
 *
 */

public class Main {

	Player player1 = new Player();
	static Main game = new Main();

	public void run() {
		Scanner keyb = new Scanner(System.in);
		String playAgain = "";
		int menuOption = 0;
		do {
			do {
				System.out
						.println("+------------------------+\n+ WELCOME TO BATTLESHIP! +\n+------------------------+"
								+ "\n   1.Player VS Computer   \n   2.Exit                 \n+------------------------+"
								+ "\n Please Select an Option  \n+------------------------+");
				menuOption = Integer.parseInt(keyb.nextLine());
			} while (menuOption != 1 && menuOption != 2);
			if (menuOption == 1) {
				player1.playerBoard.printPlayerGrid();
				player1.playerBoard.setShipInfo();

				// System.out.println("do you want to play again? (yes/no)");
				// playAgain = keyb.nextLine();
			} else {
				break;
			}
		} while (playAgain.equalsIgnoreCase("yes") || menuOption == 2);

	}

	// Win Message

	/*
	 * System.out.println(
	 * " __     __                 __          __  _           _        __  \n"
	 * +
	 * " \\ \\   / /                 \\ \\        / / (_)         | |    _  \\ \\ \n"
	 * +
	 * "  \\ \\_/ /    ___    _   _   \\ \\  /\\  / /   _   _ __   | |   (_)  | |\n"
	 * +
	 * "   \\   /    / _ \\  | | | |   \\ \\/  \\/ /   | | | '_ \\  | |        | |\n"
	 * +
	 * "    | |    | (_) | | |_| |    \\  /\\  /    | | | | | | |_|    _   | |\n"
	 * +
	 * "    |_|     \\___/   \\__,_|     \\/  \\/     |_| |_| |_| (_)   (_)  | |\n"
	 * +
	 * "                                                                /_/ \n"
	 * );
	 */

	// Lose Message

	/*
	 * System.out.println(
	 * " __     __                  _                             _          __\n"
	 * +
	 * " \\ \\   / /                 | |                           | |    _   / /\n"
	 * +
	 * "  \\ \\_/ /    ___    _   _  | |        ___    ___    ___  | |   (_) | | \n"
	 * +
	 * "   \\   /    / _ \\  | | | | | |       / _ \\  / __|  / _ \\ | |       | | \n"
	 * +
	 * "    | |    | (_) | | |_| | | |____  | (_) | \\__ \\ |  __/ |_|    _  | | \n"
	 * +
	 * "    |_|     \\___/   \\__,_| |______|  \\___/  |___/  \\___| (_)   (_) | | \n"
	 * +
	 * "                                                                    \\_\\\n"
	 * +
	 * "                                                                       "
	 * );
	 */

	public static void main(String[] args) {
		game.run();
	}

}
