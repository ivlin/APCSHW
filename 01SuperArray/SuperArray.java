public class SuperArray{
    private Object[]array;
    private int length;

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
	return str + " ]";
    }

    public void add(Object n){
	if (length >= array.length){
	    resize(length + 5);
	}
	array[length] = n;
	length ++;
    }

    public void resize(int newCapacity){
	Object[]newArray = new Object[newCapacity];
	for (int i = 0; i < newCapacity; i++){
	    newArray[i] = null;
	    if(i < length){
		newArray[i] = array[i];
	    }
	}
	array = newArray;
    }

    public int size(){
	return length;
    }

    public void clear(){
	for (int i = 0; i < array.length; i++){
	    array[i] = null;
	}
    }

    public Object get(int index){
	if (index < length){
	    return array[index];
	}
	return null;
    }

    public void set(int index, Object e){
	if (index < length){
	    array[index] = e;
	}
    }
}
