import java.util.ArrayList;
import java.util.Random;
public class Test{
    public static void main(String[]args){
	Random rand = new Random();
	ArrayList<Integer> a = new ArrayList<Integer>();
	for (int i = 0; i < 20; i ++){
	    a.add(rand.nextInt(3));
	}
	System.out.println(a);
	collapseDuplicates(a);
	System.out.println(a);
    }
    
    public static void collapseDuplicates(ArrayList x){
	for (int i = x.size() - 1; i > 0; i--){
	    if (x.get(i) == x.get(i-1)){
		x.remove(i);
	    }
	}
    }
}
