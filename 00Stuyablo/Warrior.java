public class Warrior extends Adventurer{
    private int rage;

    public Warrior(String n, int h){
	super(n,h);
	setRage(0);	
	setHP(22);
	setSTR(14);
    }

    public Warrior(String n){
	this(n,22);
    }

    public Warrior(){
	this("Grunt",22);
    }
    
    public int getRage(){
	return rage;
    }

    public void setRage(int r){
	rage = r;
    }

    public String getStats(){
	return super.getStats() + " Rage: " + getRage() ;
    }

    public void reset(){
	super.reset();
	setRage(0);
    }

    public void attack(Adventurer other){
	if (hit(other)){
	    int dmg = physDmg(other);
	    System.out.println(this + " attacks " + other + " dealing " + dmg + " damage.");
	    setRage(getRage() + 1);
	    other.setHP(other.getHP() - dmg);
	}else{
	    System.out.println(this + " missed " + other);
	} 
    }

    public void specialAttack(Adventurer other){
	if (getRage() >= 5){
	    if (hit(other)){
		int dmg = physDmg(other)  + (int)(6 * getRage())/ other.getSTR();;
		System.out.println(this + " pulverizes " + other + " dealing " + dmg + " damage.");
		other.setHP(other.getHP() - dmg);
	    }else{
		System.out.println(this + " missed " + other);
	    }
	    setRage(getRage() - 5);
	}else{
	    attack(other);
	}
    }
}
