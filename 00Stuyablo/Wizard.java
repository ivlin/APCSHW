public class Wizard extends Adventurer{
    private int mana, maxMana;
    public Wizard(){
	this("Magic Head",18);
    }

    public Wizard(String n){
	this(n,18);
    }

    public Wizard(String n, int h){
        super(n,h);
	maxMana = 20;
	setMana(20);
	setINT(14);
    }

    public int getMana(){
	return mana;
    }    
    
    public void setMana(int m){
	mana = m;
    }

    public String getStats(){
	return super.getStats() + " Mana: " + getMana();
    }

public void reset(){
	super.reset();
	setMana(maxMana);
}

    public void attack(Adventurer other){
	if (hit(other)){
	    int dmg = physDmg(other);
	    System.out.println(this + " attacks " + other + " dealing " + dmg + " damage.");
	    other.setHP(other.getHP() - dmg);
	}else{
	    System.out.println(this + " missed " + other);
	} 
    }

    public void specialAttack(Adventurer other){
	if (getMana() >= 4){
	    if (magicHit(other)){
		int dmg = magicDmg(other);
		System.out.println(this + " electrocutes " + other + " dealing " + dmg + " damage.");
		if (rand.nextDouble() < 0.5){
		    other.setINT(other.getINT() - 1);
		    System.out.println(other + " lose 1 INT to the shock therapy.");
		}
		other.setHP(other.getHP() - dmg);
	    }else{
		System.out.println(this + " missed " + other);
	    }
	    setMana(getMana() - 4);
	}else{
	    attack(other);
	}
    }

    public boolean magicHit(Adventurer other){
	return rand.nextDouble() < .4 + (getINT() - other.getINT())/getINT();
	    }

    public int magicDmg(Adventurer other){
	int a = getINT() - other.getINT();
	if (a <= 0){
	    a = 1;
	}
	return a + rand.nextInt(7);
    }
}
