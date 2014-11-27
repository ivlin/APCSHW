public class Rogue extends Adventurer{
    private int stamina, maxStamina;

    public Rogue(String n, int h){
	super(n,h);
	setStamina(15);
	maxStamina = 15;
	setDEX(15);
    }

    public Rogue(String n){
	this(n,16);
    }

    public Rogue(){
	this("Swiper the Fox",16);
    }

    public int getStamina(){
	return stamina;
    }

    public void setStamina(int s){
	stamina = s;
    }

    public String getStats(){
	return super.getStats() + " Stamina: " + getStamina();
    }

    public void reset(){
	super.reset();
	setStamina(maxStamina);
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
	if (getStamina() >= 5){
	    for (int i = 0; i < 2 ;i++){	
		if (hit(other)){
		    int dmg = physDmg(other);
		    System.out.println(this + " stabs " + other + " dealing " + dmg + " damage."); 
		    other.setHP(other.getHP() - dmg);
		}else{
		    System.out.println(this + " missed " + other);
		}
	    }
	    setStamina(getStamina() - 5);
	}else{
	    attack(other);
	}    
    }
}
