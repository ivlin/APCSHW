public class WordGrid{
    private char[][]data;

    public static void main(String[]args){
	WordGrid a = new WordGrid(10,10);
	a.addWordHorizontal("Hello",7,2);
	a.addWordVertical("Greetings",1,1);
	a.addWordDiagonalNE("Find",5,3);
	a.addWordDiagonalSE("Me",4,8);
	System.out.println(a);
    }


    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = ' ';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String str = "";
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		str += data[x][y] + " ";
	    }
	    str += '\n';
	}
	return str;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word, int row, int col){
	boolean fits = word.length() + col <= data[row].length;
	if (fits){	
	    for (int i = 0; i < word.length(); i++){
		data[row][col + i] = word.charAt(i);
	    }
	}
	return fits;
    }

    public boolean addWordVertical(String word, int row, int col){
	boolean fits = word.length() + row <= data.length;
	if (fits){	
	    for (int i = 0; i < word.length(); i++){
		data[row + i][col] = word.charAt(i);
	    }
	}
	return fits;
    }

    public boolean addWordDiagonalNE(String word, int row, int col){
	boolean fits = word.length() < row && word.length() + col <= data[row].length;
	if (fits){	
	    for (int i = 0; i < word.length(); i++){
		data[row - i][col + i] = word.charAt(i);
	    }
	}
	return fits;
    }


    public boolean addWordDiagonalSE(String word, int row, int col){
	boolean fits = word.length() + row <= data.length && word.length() + col <= data[row].length;
	if (fits){	
	    for (int i = 0; i < word.length(); i++){
		data[row + i][col + i] = word.charAt(i);
	    }
	}
	return fits;
    }
}
