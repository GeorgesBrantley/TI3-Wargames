
public class WarSun extends Ships {
//life is true amount of WS
	int extra;//amount of spare health
	int damage;
	int dship;
	
	public WarSun(){
		super();
		roll = 3;
		cap = 6;
		n = "WarSun";
		extra = 0;
		damage = 0;
		dship =0;
	}
	public void setamount (int l){
		life = l;
		extra = l;
	}
	public int num(){
		return life;
	}
	public int realnum(){//RETURN TOTAL AMOUNT OF HEALTH
		return life + (life-dship);
	}
	public boolean notD(){
		int d = damage + 1;
		if (d>extra)
			return false;
		return true;
	}
	public void damage(){
		++damage;
		++dship;
		if (damage > extra){
			--life;
			--damage;
			--extra;
			--dship;
		}
		if (dship > life)
			dship = life;
		}
	public int isD(){ //return damage
		return damage;
	}
	public String wsPrint(){
		String str = "" + life + " (Damaged: " + dship +", Undamaged : " + (life - dship) + ")";

		
		return str;
	}
}