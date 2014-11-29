//GEorge Brantley
//Used to simulate space combat in Twilight Imperium
//NEEDS MODIFIERS
//USES COMMANDERS AND SHIPS
public class Wargames extends Commanders {
	
	public Wargames(){
	}
	public void stuff(){
		System.out.println("\n\t\tTWILIGHT IMPERIUM WARGAMES\n\n");
		//create 2 commanders
	Commanders[] Gen;
	Gen = new Commanders[2];

		//get colors
	for (int x = 0; x < 2; ++x){
		Gen[x] = new Commanders();
		Gen[x].setColor();
		}
	
		//Create Fleet
	for (int x = 0; x <2; ++x){
		System.out.println("\nCommander " + Gen[x].getColor() + " Create your fleet :: \n");		
		Gen[x].fleet();	
		}
	
	
	System.out.println("\n\n\n\t\tWarGames Commence!\n\n");
	int round = 0; //Round in combat
	int whiteflag =0; //if someone retreats
	
	
//Antifighter Barrage
if ((Gen[0].dest.num() > 0 && Gen[1].fight.num() > 0) || (Gen[1].dest.num() > 0 && Gen[0].fight.num() > 0)){
	System.out.println("\n\t\tAntiFighter Barrage\n\n");
	
	for (int x = 0; x < 2; ++x)
		if (Gen[x].dest.num() > 0){
			int hits = 0;
					for (int r = 0; r < Gen[x].dest.num(); ++r)
						if (Gen[x].roll() >= Gen[x].dest.roll())
							++hits;
			System.out.println(Gen[x].getColor() + " Commanders' " + Gen[x].dest.life+ " Destroyers lands "
			+ hits + " hits on the other Commanders' Fighters");	
			if (x == 0)
				Gen[1].fight.hits(hits);
			else
				Gen[0].fight.hits(hits);
			
		}
}
	
//RECAP
for (int x =0; x<2; ++x){
	System.out.println("\n"+ Gen[x].getColor() + " Commander");
	Gen[x].recap();
}


//START
while (whiteflag ==0){

//Round Track
	++round;
	System.out.println("\n\t\tROUND "+round +"\n");
	
//Retreats 
for (int x = 0; x <2; ++x){
	if (Gen[x].retreat())
		++whiteflag;
	}

//HIT TRACKS	
int[] hit = {0,0};
System.out.println("\n\n");

//ROLL TIME
System.out.println("\t\tBATTLE" + "\n");
for (int x = 0; x <2; ++x){
		
		int tots =0;
		
		//WarSun
		for (int r = 0; r < Gen[x].ws.num()* 3; ++r){
			int c = Gen[x].roll();
				if (c >= Gen[x].ws.roll()){
					++hit[x];
					++tots;
			}}
		if (Gen[x].ws.alive())
		System.out.println(Gen[x].ws.num() + " " + Gen[x].ws + " scored " + tots + " hits");
		tots=0;
		
		//Dreadnaught
		for (int r = 0; r < Gen[x].dread.num(); ++r){
			int c = Gen[x].roll();
				if (c >= Gen[x].dread.roll()){
					++hit[x];
					++tots;
			}}
		if (Gen[x].dread.alive())
		System.out.println(Gen[x].dread.num() + " " + Gen[x].dread + " scored " + tots + " hits");
		tots=0;
		
		//CRUISERS
		for (int r = 0; r < Gen[x].cruise.num(); ++r){
			int c = Gen[x].roll();
				if (c >= Gen[x].cruise.roll()){
					++hit[x];
					++tots;
			}}
		if (Gen[x].cruise.alive())
		System.out.println(Gen[x].cruise.num() + " " + Gen[x].cruise + " scored " + tots + " hits");
		tots=0;
		
		//DESTROYERS
		for (int r = 0; r < Gen[x].dest.num(); ++r){
			int c = Gen[x].roll();
				if (c >= Gen[x].dest.roll()){
					++hit[x];
					++tots;
			}}
		if (Gen[x].dest.alive())
		System.out.println(Gen[x].dest.num() + " " + Gen[x].dest + " scored " + tots + " hits");
		tots=0;
		
		//CARRIERES
		for (int r = 0; r < Gen[x].car.num(); ++r){
			int c = Gen[x].roll();
				if (c >= Gen[x].car.roll()){
					++hit[x];
					++tots;
			}}
		if (Gen[x].car.alive())
		System.out.println(Gen[x].car.num() + " " + Gen[x].car + " scored " + tots + " hits");
		tots=0;
		
		//FIGHTERS
		for (int r = 0; r < Gen[x].fight.num(); ++r){
			int c = Gen[x].roll();
				if (c >= Gen[x].fight.roll()){
					++hit[x];
					++tots;
			}}
		if (Gen[x].fight.alive())
		System.out.println(Gen[x].fight.num() + " " + Gen[x].fight + " scored " + tots + " hits");
		tots=0;

		System.out.println("Commander " + Gen[x].getColor() + " got " + hit[x] +" hits this round\n\n");
}
	

//Causulties
for (int x = 0; x < 2; ++x){
	int a = 1 - x; //SWAP hits
	System.out.println("\n\t"+Gen[x].getColor() + " Commander has to assign "+ hit[a] + 
			" hits to his fleet\n");
	Gen[x].recap();
	Gen[x].death(hit[a]); //ASSIN HITS BRAH
}
//Recap
System.out.println("\n\t\tRECAP");
for (int x =0; x<2; ++x){
	System.out.println("\n"+ Gen[x].getColor() + " Commander");
	Gen[x].recap();
}

//Check Winner
for (int x = 0; x < 2; ++x){
	if (Gen[x].Tlife() < 1){
		System.out.println("\n\t"+Gen[x].getColor() + " Commander Runs out of troops"+"\n\t"+Gen[1-x].getColor() +" Commander is VICTORIOUS!");
		whiteflag++;
}}

	}
	}}
