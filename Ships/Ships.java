//Abstract class for all ships
//Contains the base amount
public class Ships {
public int roll; //roll for damage
public int life; //can be damaged?
public int cap; //can carry troops
public String n;
public Ships(){
	roll = 9;
	life = 0;
	cap = 0;
	n = "Ship";
}
public void hit(){ // LOSE LIFE
	life--;
}
public void hits(int h){ //Asign num of hits
	for (int x = 0; x<h; ++x)
		life--;
}
public int getcap(){ //returns capacity
	return cap;
}
public void setamount(int l){ //SET FLEET AMOUNTS
	life = l;
}
public int num(){ //RETURN AMOUNT OF SHIPS
	return life;
}
public boolean alive(){ //ARE THERE SHIPS?
	if (life <1)
		return false;
 return true;
}
public int capacity(){ //CAPACITY
	return cap;
}
public int roll(){ // RETURN ROLL AMOUNT
	return roll;
}
public String toString(){ //RETURN SHIP NAME
	n+="";
	return n;
}

}
