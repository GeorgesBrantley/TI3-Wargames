import java.util.Scanner;

public class Tictactoe {

	Scanner read = new Scanner(System.in);
	int players; // players
	String[][] board = new String[3][3];// board
	String go;// Game over

	public Tictactoe() {
		players = 2;
		board = new String[3][3];
		go = "";
		// Set board
		for (int x = 0; x < 3; ++x) {
			for (int y = 0; y < 3; ++y)
				board[x][y] = "-";
		}
	}

	public void play() throws InterruptedException {
		System.out.println("\nHow Many Players? (1-2)");
		players = read.nextInt();

		board();
		if (players == 2)
			two();
		else if (players == 1)
			one();
		else if (players == 0)
			none();
		else
			System.out.println("No registered Value");
	}

	public void none() throws InterruptedException {
		int r = 0;
		int y = 0;
		System.out.println("Computer vs Computer");
		for (int x = 0; x < 20000; ++x) {
			while (go == "") {
				System.out.println("Computer's Go");
				ComputerX();
				board();
				WIN();
				if (go == "") {// Check middle win
					System.out.println("Computer's Go");
					ComputerY();
					board();
					WIN();
				}
			}
			System.out.println(go);
			if (go.contains("X"))
				++r;
			else if (go.equals("O Win"))
				++y;

			Restart();
		}
		System.out.println(r + " " + y);
		System.out.println("\n\n" + "Strategy:      \t\tWinner:");
		Thread.sleep(1000);
		System.out.println("WarSun Gambit  \t\tNone");
		Thread.sleep(500);
		System.out.println("Rex Siege      \t\tNone");
		Thread.sleep(500);
		System.out.println("Cruiser-All-in \t\tNone");
		Thread.sleep(500);
		System.out.println("Fighter Swarm  \t\tNone");
		Thread.sleep(500);
		System.out.println("GunBoat Diplo. \t\tNone");
		Thread.sleep(500);
		System.out.println("KingMaking     \t\tNone");
		Thread.sleep(500);
		System.out.println("ReadingRuleBook\t\tNone");
		Thread.sleep(500);
		System.out.println("Diplomacy      \t\tNone");
		Thread.sleep(500);
		System.out.println("Imperium       \t\tNone");
		Thread.sleep(500);
		System.out.println("Destroyers     \t\tNone");
		Thread.sleep(500);
		System.out.println("Playing Nice   \t\tNone");
		Thread.sleep(500);
		System.out.println("Bribes         \t\tNone");
		Thread.sleep(500);
		System.out.println("Trade Sanctions\t\tNone");
		Thread.sleep(500);
		System.out.println("Surprise attk  \t\tNone");
		Thread.sleep(500);
		System.out.println("Betrayal       \t\tNone");

		System.out.println("\n\n\t\tGreetings User");
		Thread.sleep(2000);
		System.out.println("\n\t\tStrange Game\n");
		Thread.sleep(3000);
		System.out.println("\tThe Only Winning Move is Not to Play");
		Thread.sleep(3500);
		System.out.println("\n\t  How About a nice game of Chess?\n");
		Thread.sleep(5000);
	}

	public void one() {
		System.out.println("Player vs Computer Selected\nComputer is X");
		while (go == "") {
			System.out.println("Computer's Go");
			ComputerX();
			board();
			WIN();
			if (go == "") {// Check middle win
				System.out
						.println("Human Player give cordinates (one at a time, 0-2) for an O");
				placeO();
				board();
				WIN();
			}
		}
		System.out.println(go);
	}

	public void two() {
		System.out.println("Two Players");
		while (go == "") {
			System.out
					.println("Player One give cordinates (one at a time, 0-2) for an X");
			placeX();
			board();
			WIN();
			if (go == "") {// Check middle win
				System.out
						.println("Player Two give cordinates (one at a time, 0-2) for an O");
				placeO();
				board();
				WIN();
			}
		}
		System.out.println(go);
	}

	public void board() {
		String b = "";
		for (int x = 0; x < 3; ++x) {
			for (int y = 0; y < 3; ++y)
				b += board[x][y] + " ";
			b += "\n";
		}
		System.out.println("\n" + b + "\n");
	}

	public void placeX() {
		int x = read.nextInt();
		while (x < 0 || x > 2) {
			System.out
					.println("Out of Bounds, Input Coordinate again (0-2, row)");
			x = read.nextInt();
		}

		int y = read.nextInt();
		while (y < 0 || y > 2) {
			System.out
					.println("Out of BoundsInput Coordinate again (0-2, collumn)");
			y = read.nextInt();
		}

		while (!board[x][y].equals("-")) {
			System.out.println("Location Taken");
			do {
				System.out.println("Input Coordinate again (0-2, row)");
				x = read.nextInt();
			} while (x < 0 || x > 2);

			do {
				System.out.println("Input Coordinate again (0-2, collumn)");
				y = read.nextInt();
			} while (y < 0 || y > 2);
		}

		// Places an X
		board[x][y] = "X";
	}

	public void placeO() {

		int x = read.nextInt();
		while (x < 0 || x > 2) {
			System.out
					.println("Out of Bounds, Input Coordinate again (0-2, row)");
			x = read.nextInt();
		}

		int y = read.nextInt();
		while (y < 0 || y > 2) {
			System.out
					.println("Out of BoundsInput Coordinate again (0-2, collumn)");
			y = read.nextInt();
		}

		while (!board[x][y].equals("-")) {
			System.out.println("Location Taken");
			do {
				System.out.println("Input Coordinate again (0-2, row)");
				x = read.nextInt();
			} while (x < 0 || x > 2);

			do {
				System.out.println("Input Coordinate again (0-2, collumn)");
				y = read.nextInt();
			} while (y < 0 || y > 2);
		}

		// Places an X
		board[x][y] = "O";
	}

	public void ComputerX() {
		int x = 1;
		int y = 1;
		while (!board[x][y].equals("-")) {
			x = (int) (Math.random() * 3);
			y = (int) (Math.random() * 3);
			System.out.println(x + " " + y);
		}
		// Places an X
		board[x][y] = "X";
	}

	public void ComputerY() {
		int x = 1;
		int y = 1;
		while (!board[x][y].equals("-")) {
			x = (int) (Math.random() * 3);
			y = (int) (Math.random() * 3);
			System.out.println(x + " " + y);
		}
		// Places an X
		board[x][y] = "O";
	}

	public void WIN() {
		// Check End Game
		int c = 0;
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++)
				if (board[a][b].equals("X") || board[a][b].equals("O"))
					++c;
		}

		if (c == 9)
			go = "No One Wins";

		int x = 0;
		int y = 0;
		for (x = 0; x < 3; ++x) {// Horizontal
			if (board[x][0].equals("X") && board[x][1].equals("X")
					&& board[x][2].equals("X"))
				go = "X Win";
			else if (board[x][0].equals("O") && board[x][1].equals("O")
					&& board[x][2].equals("O"))
				go = "O Win";
		}
		// Check Verts
		for (y = 0; y < 3; ++y) {
			if (board[0][y].equals("X") && board[1][y].equals("X")
					&& board[2][y].equals("X"))
				go = "X Win";
			else if (board[0][y].equals("O") && board[1][y].equals("O")
					&& board[2][y].equals("O"))
				go = "O Win";

		}// Check Slants
		if (board[0][0].equals("X") && board[1][1].equals("X")
				&& board[2][2].equals("X"))
			go = "X Win";
		else if (board[0][0].equals("O") && board[1][1].equals("O")
				&& board[2][2].equals("O"))
			go = "O Win";

		if (board[0][2].equals("X") && board[1][1].equals("X")
				&& board[2][0].equals("X"))
			go = "X Win";
		else if (board[0][2].equals("O") && board[1][1].equals("O")
				&& board[2][0].equals("O"))
			go = "O Win";
	}

	public void Restart() {
		go = "";
		for (int x = 0; x < 3; ++x) {
			for (int y = 0; y < 3; ++y)
				board[x][y] = "-";
		}
	}
}
