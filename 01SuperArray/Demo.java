public class Demo{

    public static void main(String[]args){
	SuperArray a = new SuperArray();
	System.out.println(a);
	System.out.println(a.size());
	for (int i = 0; i < 12; i++){
	    a.add(i);
	}
	System.out.println(a);
	System.out.println(a.size());
	a.clear();
	System.out.println(a);
    }

}
