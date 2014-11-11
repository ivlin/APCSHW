public class SuperArray{
    private Object[]array;
    private int length;

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

    public SuperArray(){
	this(10);
    }

    public SuperArray(int l){
	length = 0;
	array = new Object[l];
    }

    public String toString(){
	String str = "[ ";
	for (int i = 0; i < length; i++){
	    str += array[i] + " ";
	}
	return str + "]";
    }

    public void add(){
	add(size(), null);
    }

    public void add(Object o){
	add(size(),o);
    }

    public void add(int index, Object o){
	length ++;
	if (size() >= array.length){
	    resize(size() * 2);
	}
	for (int i = size();i > index; i--){
	    array[i] = array[i - 1];
	}
	array[index] = o;
    }

    public Object remove(int index){
	Object removed = array[index];
	for (int i = index; inRange(i) ; i++){
	    array[i] = array[i + 1];
	}
	length--;
	if (size() < array.length / 4){
	    resize(array.length / 2);
	}
	return removed;
    }

    public void resize(int newCapacity){
	Object[]newArray = new Object[newCapacity];
	for (int i = 0; i < newCapacity; i++){
	    newArray[i] = null;
	    if(inRange(i)){
		newArray[i] = array[i];
	    }
	}
	array = newArray;
    }

    public int size(){
	return length;
    }

    public void clear(){
	resize(10);
	for (int i = 0; i < array.length; i++){
	    array[i] = null;
	}
	length = 0;
    }

    public Object get(int index){
	if (!inRange(index)){
	    throw new IndexOutOfBoundsException();
	}
	return array[index];
    }

    public Object set(int index, Object o){
	Object replaced;
	if (inRange(index)){
	    replaced = array[index];
	    array[index] = o;
	}else{
	    throw new IndexOutOfBoundsException();
	}
	return replaced;
    }

    public boolean inRange(int n){
	return !(n < 0 || n >= size()); 
    }
}
