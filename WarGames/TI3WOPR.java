//GEORGE BRANTLEY
//TWILIGHT IMPERIUM Main source
//Links to Invasion and Wargames
// Used for simulating combat in Twilight Imperium Board game

import java.util.Scanner;

//GROUND ZERO
public class TI3WOPR {
	public static void main (String[] args) throws InterruptedException{
		Scanner read = new Scanner(System.in);
		Wargames WG = new Wargames();
		Invasion in = new Invasion();
		WhatisTI wtf = new WhatisTI();
		Tictactoe ttt = new Tictactoe();
		Drills d = new Drills();
		
		System.out.println("\t\tTWILIGHT IMPERIUM WOPR\n\n\t     Would you Like to Play a Game?");
		
		System.out.println("\n1-WarGames"
				+ "\n2-Ground Invasion"
				+ "\n3-Drills"
				+ "\n4-Tic Tac Toe"
				+ "\n5-What is Twilight Imperium"

				);
	int x = read.nextInt();

if (x == 1)//Wargames
	WG.stuff();
else if (x == 2)//Invasion
	in.stuff();
else if (x == 3)//Drills
	d.Drillbabydrill();
else if (x == 4)//tic-tac-toe
	ttt.play();
else if (x == 5)//What is?
	wtf.say();


	read.close();
	System.out.println("\n\n\t\tEND SIMULATION");
	}
}
