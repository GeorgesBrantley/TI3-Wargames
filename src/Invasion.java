//GEORGE BRANTLEY
//Invasion Combat (/main)
// 9 - 8 - 14
//Used in TI3WOPR
//USES COMMANDER AND SHIPS


import java.util.Scanner;


public class Invasion {
	public int flag;//flag
	Scanner reader = new Scanner(System.in);
	//COMMANDERS
	public Commanders[] Gen = new Commanders[2];
//Default 
public Invasion(){
	flag = 0;
	Gen[0] = new Commanders();
	Gen[1] = new Commanders();
}

public void stuff(){

//Title Screen	
System.out.println("\n\t\tTWILIGHT IMPERIUM\n\n\t     SIMULATING INVASION COMBAT\n\n");

//get colors
colors();

//Set Attack Army
for (int x = 0; x < 2; ++x){
	Gen[x].Troops();
}


//Bombardment
if (Gen[0].ws.alive() || Gen[0].dread.alive())
System.out.println("\n\t\tBOMBARDMENT PHASE");

						//WARSUN
int hits =0;
if (Gen[0].ws.alive()){
	for (int r = 0; r < Gen[0].ws.num()* 3; ++r){
		int c = Gen[0].roll();
			if (c >= Gen[0].ws.roll()){
				++hits;
		}}

	System.out.println("Orbiting Warsuns landed " + hits + " hits on the defending forces");
	Gen[1].gf.hits(hits);
}
hits = 0;

//LIFE SCAN
if (scan() <2&& !Gen[1].pds.alive())//Checks to see if PDS are there
	END(scan());
else if (Gen[1].pds.alive())//SAY DREADS ARE BLOCKED
	System.out.println("PDS's block Dreadnaught Bombardment");
//DREADS BOMB
else{
	if (!Gen[1].pds.alive() && Gen[0].dread.alive()){
		for (int r = 0; r <Gen[0].dread.num(); ++r){
			int c = Gen[0].roll();
			if (c >= Gen[0].dread.roll())		
				++hits;
				}

		System.out.println("Orbiting Dreadnaughts Landed " +hits + " hits on the defending forces");
		Gen[1].gf.hits(hits);
}}

				//PDS
if (flag == 0)
if (scan() < 2 && !Gen[1].pds.alive())//Life Scan and to see if PDS there
	END(scan());
else{
System.out.println("\n\t\tPDS FIRE");
	if (Gen[1].pds.alive()){
		for (int r = 0; r< Gen[1].pds.life; ++r){
			int c = Gen[1].roll();
			if (c >= Gen[1].pds.roll())
				++hits;	
	}
System.out.println("Ground PDS fire at the invading Army and score " + hits);
Gen[0].gf.hits(hits);}
}

				//GROUND COMBAT
if (flag == 0)
if (scan() < 2)
	END(scan());
else{
		System.out.println("\n\n\t\tGROUND COMBAT");
		int y = 0;//Round
	while (flag == 0){
		int[] hitx = new int[2];
		
		//Show Recap
		System.out.println("\n\tRound " + y +
				"\n" + Gen[0].getColor() +" Forces: " + Gen[0].gf.num()+
				"\n" +Gen[1].getColor()+" Forces: " + Gen[1].gf.num());
		
		//GET HITS
		for (int x = 0; x < 2; ++x){
			for (int r = 0; r< Gen[x].gf.num(); ++r){
				int c = Gen[x].roll();
					if (c >= Gen[x].gf.roll())
					++hitx[x];
				}
		}
		//LAND HITS
		for (int x = 0; x < 2; ++x){
			System.out.println(Gen[x].getColor() + " Commander scores " + hitx[x] +" hits");
			Gen[1-x].gf.hits(hitx[x]);
			hitx[x] = 0;	
		}
		if (!Gen[1].gf.alive())
			Gen[1].destruction();
			
		++y;
		//CHECK FOR WIN
		if (scan() < 2){
			END(scan());}
	}
}
}

//LIFE SCAN, check for forces
//RETURN 0: DEAD DEFENSE
//RETURN 1; DEAD OFFENSE
//RETURN 2: No dead :)
public int scan(){
	int x = 0;
	
	for (x = 0; x<2; ++x){
		if(Gen[x].Glife()<  1){
			return x;
			}
	}
return x;
}
public void END(int r){
	if (r==0){
		++flag;
		System.out.println("\n\t\tDEFENDER WINS!\nRemaining Troops: " + Gen[1].gf.num());}
	else if (r==1){
		++flag;
		System.out.println("\n\t\tINVADER WINS!\nRemaining Troops: " + Gen[0].gf.num());}
}
public void colors(){
	System.out.println("Enter the color of the Invader: ");
	Gen[0].giveColor(reader.nextLine() + " (Invader)");
	System.out.println("Enter the color of the Defender: ");
	Gen[1].giveColor(reader.next() + " (Defender)");
	
}
}
