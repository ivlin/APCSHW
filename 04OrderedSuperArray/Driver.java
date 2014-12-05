import java.util.*;
public class Driver{
    public static void main(String[]args){
	
	SuperArray n = new SuperArray();
	Random rand = new Random();
	
	for (int i = 0; i < 500000; i ++){
	    n.add(i + "");
	}
	//	System.out.println(n);

	n.selectionSort();
	//	n.insertionSort();
	//System.out.println(n);	

	/*
	int earliest = n.find("x");
	System.out.println(earliest);
	if (earliest >= 0 && earliest < n.size()){
	    System.out.println(n.get(earliest));
	}
	System.out.println(n);
	*/
	} 
}

