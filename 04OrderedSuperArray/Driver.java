import java.util.*;
public class Driver{
    public static void main(String[]args){

	SuperArray n = new OrderedSuperArray();
	Random rand = new Random();
	
	for (int i = 0; i < 50; i ++){
	    n.add((char)('a' + rand.nextInt(26)) + "");
	}

	/*
	System.out.println(n);
	long start = System.currentTimeMillis();
	n.insertionSort();
	//n.badInsertionSort();
	long end = System.currentTimeMillis();
	System.out.println(n);
	System.out.println(end - start + "ms");
	*/

	int earliest = n.find("x");
	System.out.println(earliest);
	if (earliest >= 0 && earliest < n.size()){
	    System.out.println(n.get(earliest));
	}
	System.out.println(n);
	}   
}