public class MartialArtist extends Adventurer{
    int qi, maxQi;

    public MartialArtist(String n, int h){
	setName(n);
	setHP(h);
	setQi(20);
	maxQi = 20;
	setSTR(12);
	setDEX(12);
	setINT(12);
    }

    public MartialArtist(String n){
	this(n,18);
    }

    public MartialArtist(){
	this("MrMcZen",18);
    }

    public void setQi(int q){
	qi = q;
    }

    public int getQi(){
	return qi;
    }

    public String getStats(){
	return super.getStats() + " Qi: " + getQi();
    }

    public void reset(){
	super.reset();
	setQi(maxQi);
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
	if (getQi() >= 6){
	    if (hit(other)){
		int dmg = physDmg(other);
		System.out.println(this + " flips " + other + " dealing " + dmg + " damage.");
		other.setHP(other.getHP() - dmg);
		setHP(getHP() + 2);
	    }else{
		System.out.println(this + " missed " + other);
	    }
	    setQi(getQi() - 6);
	}else{
	    attack(other);
	}
    }
}
