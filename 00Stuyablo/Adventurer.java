import java.util.Random;
public class Adventurer{
    private String name;
    private int maxHP, HP, XP, STR, DEX, INT;
    Random rand = new Random();

    public Adventurer(){
	this("Bob",18);
    }

    public Adventurer(String n){
	this(n,18);
    }

    public Adventurer(String n,int h){
	setName(n);
	maxHP = h;
	setHP(h);
	setSTR(10);
	setDEX(10);
	setINT(10);
    }

    public String getName(){
	return name;
    }

    public int getHP(){
	return HP;
    }

    public int getSTR(){
	return STR;
    }

    public int getDEX(){
	return DEX;
    }

    public int getINT(){
	return INT;
    }

    public void setName(String newName){
	name = newName;
    }

    public void setHP(int newHP){
	HP = newHP;
    }

    public void setSTR(int s){
	STR = s;
    }

    public void setDEX(int d){
	DEX = d;
    }

    public void setINT(int i){
	INT = i;
    }
    
    public String toString(){
	return getName();	
    }

    public String getStats(){
	return getName() + " " + getHP() + " HP\n " + " STR: " + getSTR()  + " DEX: " + getDEX() + " INT: " + getINT();
    }

public void reset(){
	setHP(maxHP);	
}

    public void rest(){
	Random rand = new Random();
	int healed = 1 + rand.nextInt(getINT() / 4 + 1);
	setHP(getHP() + healed);
	System.out.println(getName() + " healed himself for " + healed + " HP.");
    }

    public void attack(Adventurer other){
	int dmg = physDmg(other);
	if (hit(other)){
	    System.out.println(this + " attacks " + other + " dealing " + dmg + " damage.");
	    other.setHP(other.getHP() - dmg);
	}else{
	    System.out.println(this + " missed " + other);
	} 
    }

    public void specialAttack(Adventurer other){
	if (hit(other)){
	    int dmg = rand.nextInt(2) + physDmg(other);
	    System.out.println(this + " angrily attacks " + other + " dealing " + dmg + " damage.");
	    other.setHP(other.getHP() - dmg);
	}else{
	    System.out.println(this + " missed " + other);
       }
    }

    public boolean hit(Adventurer other){
	return rand.nextDouble() < .4 + (getDEX() - other.getDEX())/getDEX();
    }

    public int physDmg(Adventurer other){
	int a = getSTR() - other.getSTR();
	if (a <= 0){
	    a = 1;
	}
	return a + rand.nextInt(5);
    }
}	      

