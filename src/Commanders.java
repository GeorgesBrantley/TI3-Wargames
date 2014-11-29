//Gives each General a Fleet
//Top Class
//Seperated in where things are used


import java.util.Scanner;


public class Commanders {
String color;
Scanner read = new Scanner(System.in);
boolean flag; //White flag
///////////////////SHIPS////////////////////
public WarSun ws = new WarSun();
public Dread dread = new Dread();
public Cruisers cruise = new Cruisers();
public Destroyers dest = new Destroyers();
public Carriers car = new Carriers();
public Fighters fight = new Fighters();
public GroundF gf = new GroundF();
public PDS pds = new PDS();

public Commanders(){
	color = "White";
	flag = false;
}

////////////////////ALL///////////////////////////////
//set color
public String getColor(){
	return color;
}
//ROLL
public int roll(){ 
	return (int) (Math.random()*10)+ 1;
}
//all the life
public int Tlife(){
	return ws.realnum() + dread.realnum() + cruise.num() + dest.num() + car.num() + fight.num() + gf.num();
}

//RETREAT
public boolean retreat(){
	System.out.println("Does " + getColor() + " Commander wish to Retreat? "
			+ "\n(one more round of battle will still commence)\n(Y/N):: ");
	String c = read.next();
	if (c.equals("Y") || c.equals("y"))
		return true; // retreat
	else 
		return false; //no retreat
}

//RECAP
public void recap(){
	System.out.print("\tSHIPS\n");
	if (ws.alive())
		System.out.println("\tWarsuns: " + ws.wsPrint());
	if (dread.alive())
		System.out.println("\tDreadnaughts: " + dread.dreadPrint());
	if (cruise.alive())
		System.out.println("\tCruisers: " + cruise.num());
	if (dest.alive())
		System.out.println("\tDestroyers: " + dest.num());
	if (car.alive())
		System.out.println("\tCarriers: " + car.num());
	if (fight.alive())
		System.out.println("\tFighters: " + fight.num());
	if (gf.alive())
		System.out.println("\tGround Forces: " + gf.num());
}
//Destroys entire fleet
public void destruction(){
	ws.setamount(0);
	dread.setamount(0);
	cruise.setamount(0);
	dest.setamount(0);
	car.setamount(0);
	fight.setamount(0);
	gf.setamount(0);
	pds.setamount(0);
}

/////////////////////WAR GAMES/////////////////////////
public void setColor(){
	System.out.println("Please input the Color for a Commander: ");
	String p = read.nextLine();
	
	color = p;
}
//casulties
public void death(int x){
	int i = 0; //Input
	int flag = 0;//If hit assigned
	
	//If too much destruction
	if (x >= Tlife()){
		System.out.println("Commander " +getColor() + "'s Fleet cannot take " +x + " hits and is DESTROYED");
		destruction();}
	
	else//Loop assigning hits
	while (x > 0){
		flag = 0;
		System.out.println(x + " Hits left\n" + runD());
		i = read.nextInt();
		flag = hit(flag,i);
		if (flag > 0)
			--x;
	}
}
//String funciton. easy
public String runD(){
	return "\n"
			+ "1-warsun \n2-Dreadnaught \n3-Cruisers \n4-Destroyers"
			+ "\n5-Carriers \n6-Fighters \n7-RECAP";
}
//Case function casulties
public int hit(int flag2, int i2){ //if it works, the imputed number
			//CHeck for bad numbers
			while (i2 < 1 || i2 >7 ){
				System.out.println(runD());
				System.out.println("ERROR, must be 1-7\nInput again: ");
				 i2 = read.nextInt();
				}
	if (i2 == 1){
		if (ws.alive()){
			//NOT WORKING
				if (fight.num() <= (ws.getcap()*(ws.num()-1) + car.getcap()*car.num()) || ws.notD()){
					ws.damage();
					++flag2;
				}
				else System.out.println("Error, not enough Capacity"); //Check for capacity
		}}
	else if (i2 == 2){
		if (dread.alive()){
		dread.damage();
		++flag2;
		}}
	else if (i2 ==3){
		if (cruise.alive()){
		cruise.hit();
		++flag2;
		}}
	else if (i2 == 4) {
		if (dest.alive()){
		dest.hit();
		++flag2;
		}}
	else if (i2 == 5){
		if (car.alive()){
			if (fight.num() <= (6*ws.num() + 6*(car.num()-1))){
				car.hit();
				++flag2;
			}
			else	System.out.println("Error, not enough Capacity"); //Check for capacity
		}}
	else if (i2 == 6) {
		if (fight.alive()){
		fight.hit();
		++flag2;
		}}
	else if (i2 == 7) 
		recap();
	
	return flag2;
}
//Create FLeet
public void fleet(){
	System.out.println("How many WarSuns? ");
		ws.setamount(read.nextInt());
	System.out.println("How many Dreadnaughts? ");
		dread.setamount(read.nextInt());	
	System.out.println("How many Cruisers? ");
		cruise.setamount(read.nextInt());
	System.out.println("How many Destroyers? ");
		dest.setamount(read.nextInt());
	System.out.println("How many Carriers? ");
		car.setamount(read.nextInt());
	System.out.println("How many Fighters? ");
		fight.setamount(read.nextInt());
		while (fight.num() > ws.capacity()*ws.num() + car.capacity()*car.num()){
			System.out.println("Error, too many fighters per capacity (" +(ws.capacity()*ws.num() + car.capacity()*car.num())
			+ " max capacity) \nReEnter: ");
			fight.setamount(read.nextInt());
		}}

//////////////////////INVASION/////////////////////////
public void giveColor(String r){
	color = r;
}
public void Troops(){	
		//Attacker
	if (getColor().contains("Invader")){
		System.out.println("\n\t" + getColor() + " Commander, create your Invasion Force: ");
		System.out.println("How many WarSuns? ");
			ws.setamount(read.nextInt());
		System.out.println("How many Dreadnaughts? ");
			dread.setamount(read.nextInt());
	}
		
		//Defender
	if (getColor().contains("Defender")){
		System.out.println("\n\t" +getColor() + " Commander, create your defending force: ");
		System.out.println("How many PDSs: ");
		pds.setamount(read.nextInt());
	}
	System.out.println("How many Ground Forces? ");
		gf.setamount(read.nextInt());
		
	}
public int Glife(){
	return gf.num() + pds.num();
}
}

