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
}
    
