import java.util.*;
public class Sorts{

    public static void main(String[] args){
	Random rand = new Random();
	int[]array = new int[10];
	for (int i = 0; i < 10; i++){
	    array[i] = rand.nextInt(50);
	}
	System.out.println(Arrays.toString(array));
	//Sorts.bubble(array);
	//Sorts.selection(array);
	//Sorts.insertion(array);
	System.out.println(Arrays.toString(array));

    }

    public static void bubble(int[] c){
	for (int x = 0; x < c.length; x ++){
	    for (int i = 0; i < c.length - x - 1; i ++){
		if (c[i] > c[i + 1]){
		    int hold = c[i];
		    c[i] = c[i + 1];
		    c[i + 1] = hold;
		}
	    }
	}	
    }


    public static void insertion(int[] c){
	for (int x = 0; x < c.length;x++){
	    int i = x;
	    while (i >= 0 && c[x] <= c[i]){
		i--;
	    }
	    int hold = c[x];
	    for (int n = i + 1; n <= x; n ++){
		int z = c[n];
		c[n] = hold;
		hold = z;
	    }
	}
    }

    public static void selection(int[] c){
	for (int i = 0; i < c.length; i ++){
	    int lowest = i;
	    for (int x = i; x < c.length; x ++){
		if (c[x] < c[lowest]){
		    lowest = x;
		}
	    }
	    int replaced = c[i];
	    c[i] = c[lowest];
	    c[lowest] = replaced;
	}
    }
}
    
