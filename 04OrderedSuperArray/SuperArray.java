import java.util.*;
public class SuperArray{
    private String[]array;
    private int length;

    public SuperArray(){
	this(10);
    }

    public SuperArray(int l){
	length = 0;
	array = new String[l];
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

    public void add(String o){
	add(size(),o);
    }

    public void add(int index, String o){
	length ++;
	if (size() >= array.length){
	    resize(size() * 2);
	}
	for (int i = size();i > index; i--){
	    array[i] = array[i - 1];
	}
	array[index] = o;
    }

    public void insertionSort(){
	for (int x = 0; x < size();x++){
	    int i = x;
	    while (i >= 0 && get(x).compareTo(get(i)) <= 0){
		i--;
	    }
	    String str = get(x);
	    for (int n = i + 1; n <= x; n ++){
		str = set(n, str);
	    }
	}
    }

    public void selectionSort(){
	for (int i = 0; i < size(); i ++){
	    int lowest = i;
	    for (int x = i; x < size(); x ++){
		if (get(x).compareTo(get(lowest)) < 0){
		    lowest = x;
		}
	    }
	    String replaced = set(i, get(lowest));
	    set(lowest, replaced);
	}
    }

    public String remove(int index){
	String removed = array[index];
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
	String[]newArray = new String[newCapacity];
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

    public String get(int index){
	if (!inRange(index)){
	    throw new IndexOutOfBoundsException();
	}
	return array[index];
    }

    public String set(int index, String o){
	String replaced;
	if (inRange(index)){
	    replaced = array[index];
	    array[index] = o;
	}else{
	    throw new IndexOutOfBoundsException();
	}
	return replaced;
    }

    public int find(String str){
	for (int i = 0; i < size(); i++){
	    if (str.equals(get(i))){
		return i;
	    }
	}
	return -1;
    }

    public boolean inRange(int n){
	return !(n < 0 || n >= size()); 
    }
}
