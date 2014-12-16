public class Sorts{
   
    public static void main(String[] args){
	int[]array = new int[10];
	for (int i = 0; i < 10; i++){
	    array[i] = i;
	}
	for (int i = 0; i < 10; i++){
	    System.out.print(i);
	}
    }

    public static void bubble(int[] c){
	for (int x = 0; x < c.length; x ++){
	    for (int i = x; i < c.length; i ++){
		if (c[i] > c[i + 1]){
		    int hold = c[i];
		    c[i] = c[i + 1];
		    c[i + 1] = hold;
		}
	    }
	}	
    }
}
    