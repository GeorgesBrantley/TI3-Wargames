
public class Dread extends Ships {
	//life is true amount of dread
		int extra;//amount of spare health
		int damage;
		int dship;
		
	public Dread (){
		super();
		roll = 5;
		n = "Dreadnaught";
		extra = 0;
		damage =0;
		dship = 0;
	}
	public void setamount (int l){
		life = l;
		extra = l;
	}
	public void damage(){
		++damage;
		++dship;
		if (damage > extra){
			--life;
			--extra;
			--damage;
			--dship;}
		if (dship > life)
			dship = life;
			
		}
	public int realnum(){//RETURN TOTAL AMOUNT OF HEALTH
		return life + (life-dship);
	}
	public int isD(){ //return damage
		return damage;
	}
	public String dreadPrint(){//Print amount damaged

			String str = "" + life + " (Damaged: " + dship +", Undamaged : " + (life - dship) + ")";

			
			return str;}
}
