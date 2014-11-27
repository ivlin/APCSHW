import java.util.Scanner;
import java.util.Random;
public class Game{
    public static void main(String[]args){

	Scanner sc = new Scanner(System.in);
	
	boolean gameOver = false;
	
		Adventurer[]party;	
		party = chooseParty();


	while (!gameOver){
for (int i = 0; i < party.length; i++){
party[i].reset();
}
		Adventurer opponent = aiChooseCharacter();
		opponent.setHP(party.length * opponent.getHP());
		combat(party,opponent);
	    System.out.println("\nDo you want to stop? If so, type STOP. Otherwise, press ENTER to play another round.");
	    gameOver = sc.nextLine().equalsIgnoreCase("STOP");
	}	       
    }
    
    public static Adventurer aiChooseCharacter(){
	Adventurer opponent = null;
	Random rand = new Random();
	int oppType = rand.nextInt(4);
	if (oppType == 0){
	    opponent = new Warrior();
	}else if (oppType == 1){
	    opponent = new Wizard();
	}else if (oppType == 2){
	    opponent = new Rogue();
	}else {
	    opponent = new MartialArtist();
	}
	return opponent;
    }

    public static Adventurer chooseCharacter(){
	Scanner sc = new Scanner(System.in);
	System.out.println("What is your character's name?");
	String charName = sc.nextLine();
	Adventurer player = new Adventurer();

	String type = "";
	System.out.println("Choose a class \n A : Warrior \n B : Wizard \n C : Rogue \n D : Martial Artist");	
	while (!(type.equals("A") || type.equals("B") || type.equals("C") || type.equals("D"))){
	    type = sc.nextLine();
	    if (type.equals("A")){
		System.out.println("You have selected Warrior for " + charName);
		player = new Warrior(charName);
	    }else if(type.equals("B")){
		System.out.println("You have selected Wizard for " + charName);
		player = new Wizard(charName);
	    }else if (type.equals("C")){
		System.out.println("You have selected Rogue for " + charName);
	        player = new Rogue(charName);
	    }else if (type.equals("D")){
		System.out.println("You have selected Martial Artist for " + charName);
	        player = new MartialArtist(charName);
	    }else{
		System.out.println("Please select a valid option");
	    }
	}
	return player;
    }

    public static Adventurer[] chooseParty(){
	Adventurer[]party;
	Scanner sc = new Scanner(System.in);
	System.out.println("How many members are in your party?");
	int partyNumber = sc.nextInt();
	party = new Adventurer[partyNumber];
	for (int i = 0; i < partyNumber; i++){
	    System.out.println("\nReady Player " + (i + 1));
	    party[i] = chooseCharacter();
	    setStats(party[i]);
	}
	return party;
    }
    
    public static void playerAttack(Adventurer player, Adventurer opponent){
	Scanner sc = new Scanner(System.in);
	String choice = "";
	System.out.println("\nChoose an acton: \n A : attack \n S : special attack \n G : set HP zero \n R : rest");
	while (!(choice.equalsIgnoreCase("R")||choice.equalsIgnoreCase("A")||choice.equalsIgnoreCase("S")||choice.equalsIgnoreCase("G"))){
	    choice = sc.nextLine();
		if (choice.equalsIgnoreCase("A")){
		    player.attack(opponent);
		}else if (choice.equalsIgnoreCase("S")){
		    player.specialAttack(opponent);
		}else if (choice.equalsIgnoreCase("G")){
		    player.setHP(0);
		    System.out.println("You lost");
		}else if (choice.equalsIgnoreCase("R")){
		    player.rest();
		}else{
		    System.out.println("Please select a valid option");
		}
	}
    }

    public static void setStats(Adventurer player){
	int pts = 30;
	System.out.println("Each character starts out with 1 point of STR, DEX, and INT");
	System.out.println("You have 30 points to distribute between STR, DEX and INT.");
	System.out.println("How many points do you want to spend on STR?");
	int STR = getPositive(pts);
	player.setDEX(1);
	player.setINT(1);
	player.setSTR(STR + 1);
	pts -=STR;
	if (pts > 0){
	    System.out.println("How many points do you want to spend on DEX?");
	    int DEX = getPositive(pts);
	    player.setDEX(DEX + 1);
	    pts -= DEX;
	    System.out.println("The remaining " + pts + " points have been spent on INT.");
	    player.setINT(pts + 1);
	}
    }

    public static int getPositive(int max){
	Scanner sc = new Scanner(System.in);
	int n = -1;
	while (n < 0 || n > max){
	    n = sc.nextInt();
	    if (n >= 0 && n <=max){
		return n;
	    }
	    System.out.println("Please select a an integer between 1 and " + max);
	}
	return n;
    }
    
    public static void aiAttack(Adventurer opponent, Adventurer[]party){
	Random rand = new Random();
	//Select prey
	int i = 0;
	while (party[i].getHP() <= 0){
	    i = rand.nextInt(party.length);
	}
	if (rand.nextInt(2) == 0){
	    opponent.attack(party[i]);
	}else{
	    opponent.specialAttack(party[i]);
	}
    }


    public static void combat(Adventurer[]party, Adventurer other){
	int turn = 1;
	while (isAlive(party) && other.getHP() > 0){
	    System.out.println("\nTurn " + turn + " \n");
	    for (int i = 0; i < party.length; i ++){
		System.out.println("[Party Player " + (i + 1) + "] " + party[i].getStats());
	    }
	    System.out.println(other.getStats());
	    for (int i = 0; i < party.length; i ++){
		if (party[i].getHP() > 0 && other.getHP() > 0){
		    System.out.println("\n[Party Player " + (i + 1) + "] " + party[i].getName() + "'s turn");
		    playerAttack(party[i],other);
		}
	    }
	    if (other.getHP() > 0){
	    System.out.println("\nComputer's turn\n" + other.getStats() + "\n");
	    aiAttack(other, party);
	    System.out.println();
	    }else{
		System.out.println("You have won. The final results: ");
	    }
	turn++;
	}

	if (!isAlive(party)){
	    System.out.println("You have lost. The final results: ");
	}

	for (int i = 0; i < party.length; i ++){
	    System.out.println("[Party Player " + (i + 1) + "] " + party[i].getStats());
	}
	System.out.println(other.getStats());
    }

    public static boolean isAlive(Adventurer[]party){
	boolean survivors = false;
	for (int i = 0; i < party.length; i++){
	    survivors = survivors || party[i].getHP() > 0;
	}
	return survivors;
    }
}

