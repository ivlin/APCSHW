public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(int length){
	super(length);
    }

    public OrderedSuperArray(){
	super();
    }

    public void add(String str){
	int i = 0;
	while (i < size() && str.compareTo(get(i)) > 0){
	    i++;
	}
	super.add(i, str);
    }

    public void add(int index, String str){
	this.add(str);
    }

    public String set(int index, String str){
	String removed = remove(index);
	add(str);
	return removed;
    }
    
    public int find(String str){
	int upper = size();
	int lower = -1;
	int i = (upper + lower) / 2;
	while (upper - lower > 2){
	    if (str.compareTo(get(i)) <= 0){
		upper = i + 1;
	    }else{
		lower = i;
	    }
	    i = (upper + lower) / 2;
	}
	if (!str.equals(get(i))){
	    return -1;
	}
	return i;
    }
}
