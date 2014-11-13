import java.util.*;
public class ArrayListMethods{
    public static void main(String[]args){
	Random rand = new Random();
	ArrayList<Integer> a = new ArrayList<Integer>();
	for (int i = 0; i < 20; i ++){
	    a.add(rand.nextInt(3));
	}
	System.out.println(a);
	collapseDuplicates(a);
	System.out.println(a);
	randomize(a);
	System.out.println(a);
    }
    
    public static void collapseDuplicates(ArrayList x){
	for (int i = x.size() - 1; i > 0; i--){
	    if (x.get(i) == x.get(i-1)){
		x.remove(i);
	    }
	}
    }

    public static void randomize(ArrayList<Integer> L){
	Random rand = new Random();
	for (int i = 0; i < L.size(); i ++){
	    L.set(i, L.get(i + rand.nextInt(L.size() - i)));
	}
    }
}
