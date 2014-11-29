//Sees how effiecient a fleet is
public class Drills {

	public Drills(){
		
	}
	public void Drillbabydrill(){
		System.out.println("\n\t\tTWILIGHT IMPERIUM DRILS\n\n");
		System.out.println("Create a fleet and see its average hits and life");
		Commanders gen = new Commanders();
		
		System.out.println("\nCommander Create your fleet :: \n");	
		gen.fleet();
	
		double hit = 0;//Hits in total
		
		double war, dread, cruise, dest, car, fight = 0;//hits pership
		war = dread = cruise = dest = car = fight;
		
//COMBAT LOOP
	for (int x = 0; x <100; ++x){
		//WarSuns
		for (int r = 0; r < gen.ws.num()* 3; ++r){
			int c = gen.roll();
			if (c >= gen.ws.roll()){
				++hit;
				++war;}
			}
		//dread
		for (int r = 0; r < gen.dread.num()* 3; ++r){
			int c = gen.roll();
			if (c >= gen.dread.roll()){
				++hit;
				++dread;}
			}
		//Cruise
		for (int r = 0; r < gen.cruise.num()* 3; ++r){
			int c = gen.roll();
			if (c >= gen.cruise.roll()){
				++hit;
				++cruise;}
			}
		//Dest
		for (int r = 0; r < gen.dest.num()* 3; ++r){
			int c = gen.roll();
			if (c >= gen.dest.roll()){
				++hit;
				++dest;}
			}
		//Carriers
		for (int r = 0; r < gen.car.num()* 3; ++r){
			int c = gen.roll();
			if (c >= gen.car.roll()){
				++hit;
				++car;}
			}
		//Fighters
		for (int r = 0; r < gen.fight.num()* 3; ++r){
			int c = gen.roll();
			if (c >= gen.fight.roll()){
				++hit;
				++fight;}
			}
}//end combat
System.out.println("\n\nThe Fleet On average scored " + hit/100 + " hits");
System.out.println("\nPer Ship Breakdown:");
System.out.println("Warsuns: " + war/100);
System.out.println("Dreadnaughts: " + dread/100);
System.out.println("Cruisers: " + cruise/100);
System.out.println("Destroyers: " + dest/100);
System.out.println("Carriers: " + car/100);
System.out.println("Fighters: " + fight/100);



}}