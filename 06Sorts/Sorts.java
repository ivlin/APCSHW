import java.util.*;
public class Sorts{

    public static void main(String[] args){
	int [] a = new int[10];
	Random rand = new Random();
	for (int i = 0; i < a.length; i++){
	    a[i] = rand.nextInt(100);
	}
	System.out.println(Arrays.toString(a));
	Sorts.radix(a);
    }

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
	ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
	for (int r = 0; r < 10; r++){
	    b.add(new ArrayList<Integer>());
	}
	int  max = c[0];
	for (int f = 1; f < c.length; f++){
	    if (c[f] > max){
		max = c[f];
	    }
	}
	int digits = 1;
	while (max > 1){
	    max = max / 10;
	    for (int i = 0; i < c.length; i++){
		b.get(c[i] % (int)(Math.pow(10, digits))).add(c[i]);
	    }
	    int returns = 0;
	    System.out.println(b.toString());
	    for (ArrayList<Integer> r : b){
		for (Integer n : r){
		    c[returns] = n;
		    returns++;
		}
	    }
	    digits ++;
	    break;
	}
	System.out.println(Arrays.toString(c));
    }
}

