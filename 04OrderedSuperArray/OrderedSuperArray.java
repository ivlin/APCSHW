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
}
