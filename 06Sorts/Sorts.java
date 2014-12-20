import java.util.*;
public class Sorts{

    public static void bubble(int[] c){
	int hold;
	for (int x = 0; x < c.length; x ++){
	    for (int i = 0; i < c.length - x - 1; i ++){
		if (c[i] > c[i + 1]){
		    hold = c[i];
		    c[i] = c[i + 1];
		    c[i + 1] = hold;
		}
	    }
	}	
    }


    public static void insertion(int[] c){
	int i, z, hold;
	for (int x = 0; x < c.length;x++){
	    i = x;
	    while (i >= 0 && c[x] <= c[i]){
		i--;
	    }
	    hold = c[x];
	    for (int n = i + 1; n <= x; n ++){
		z = c[n];
		c[n] = hold;
		hold = z;
	    }
	}
    }

    public static void selection(int[] c){
	int lowest, replaced;
	for (int i = 0; i < c.length; i ++){
	    lowest = i;
	    for (int x = i; x < c.length; x ++){
		if (c[x] < c[lowest]){
		    lowest = x;
		}
	    }
	    replaced = c[i];
	    c[i] = c[lowest];
	    c[lowest] = replaced;
	}
    }

    public static void radix(int[] c){
	//makes buckets
	ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
	for (int r = 0; r < 10; r++){
	    b.add(new ArrayList<Integer>());
	}
	//find max
	int  max = c[0];
	for (int f = 1; f < c.length; f++){
	    if (c[f] > max){
		max = c[f];
	    }
	}
	int returns;
	for (int digit = 1; digit <= ("" + max).length(); digit ++){
	    for (int i = 0; i < c.length; i++){
		b.get((int)(Math.floor(c[i] / Math.pow(10, digit - 1)) % 10)).add(c[i]);
	    }
	    returns = 0;
	    for (ArrayList<Integer> r : b){
		for (Integer n : r){
		    c[returns] = n;
		    returns++;
		}
		r.clear();
	    }
	}
    }
}

