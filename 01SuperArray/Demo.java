public class Demo{

    public static void main(String[]args){
	SuperArray a = new SuperArray();
	System.out.println(a);
	System.out.println(a.size());
	a.add();
	a.set(0,"first");
	a.add(1,"second");
	try{
	    a.set(1,"hi");
	    a.get(100);
	}
	catch (IndexOutOfBoundsException e){
	    System.out.println("Index out of bounds");
	}
	System.out.println(a);
	for (int i = 0; i < 400; i ++){
	    a.add(i);
	}
	System.out.println(a);
	System.out.println(a.get(4));
	System.out.println(a.get(15));
	for (int i = 0; i < 399; i ++){
	    a.remove(2);
	}
	System.out.println(a);

    }


}
