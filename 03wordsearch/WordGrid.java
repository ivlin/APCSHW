import java.util.*;
import java.io.*;
public class WordGrid{
    private char[][]data;

    public static void main(String[]args) throws FileNotFoundException{
	Random rand = new Random();
	WordGrid a = new WordGrid(10,10);
	
	a.addWordHorizontal("Hello",7,2);
	a.addWordVertical("Greetings",1,1);
	a.addWordDiagonalNE("Find",5,3);
	a.addWordDiagonalSE("Me",4,8);
	a.addWordVertical("charlmagne",0,5);
	System.out.println(a);
	a.addWordHorizontal("energy",3,2);
	a.addWordVertical("cologne",2,7); 
	System.out.println(a);
	

	File infile = new File("./wordlist.txt");
	Scanner sc = new Scanner(infile);
	sc.useDelimiter(" ");
	ArrayList<String> wordList = new ArrayList<>();
	while (sc.hasNext()){
	    wordList.add(sc.next());
	}
	for (int i = 0; i < wordList.size(); i++){
	    a.addWord(wordList.get(i), rand.nextInt(a.data.length), rand.nextInt(a.data[0].length), 0, 1);
	}
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

    /**Initialize the grid to the default size of 10 by 10
     */
    public WordGrid(){
	this(10,10);
    }


    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = '.';
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
	    addWord(word, row, col, 0, 1);
	}
	return fits;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordVertical(String word, int row, int col){
	boolean fits = word.length() + row <= data.length;
	if (fits){	
	    addWord(word, row, col, 1, 0);
	}
	return fits;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, bottom to top, and must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonalNE(String word, int row, int col){
	boolean fits = word.length() < row && word.length() + col <= data[row].length;
	if (fits){	
	    addWord(word, row, col, -1, 1);
	}
	return fits;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, top to bottom, and must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonalSE(String word, int row, int col){
	boolean fits = word.length() + row <= data.length && word.length() + col <= data[row].length;
	if (fits){
	    addWord(word, row, col, 1, 1);
	}
	return fits;
    }


    private void addWord(String word, int startY, int startX, int shiftY, int shiftX){
	int distance = checkSpace(startY, startX, shiftY, shiftX);
	int endY = startY + distance * shiftY;
	int endX = startX + distance * shiftX;
       	if (distance >= word.length() && data[startY][startX] == '.'){
	    for (int i = 0; i < word.length(); i++){
		data[startY + i * shiftY][startX + i * shiftX] = word.charAt(i);
	    }
	}else if(endY >= 0 && endY < data.length && endX >=0 && endX < data[0].length){
	    fixOverlap(word, endY, endX);
	}
    }

    private int checkSpace(int startY, int startX, int shiftY, int shiftX){
	int i = 1;
	int nextY = startY + shiftY;
	int nextX = startX + shiftX;
	if (nextY >= 0 && nextY < data.length && nextX >= 0 && nextX < data[0].length && data[nextY][nextX] == '.'){
	    i += checkSpace(startY + shiftY, startX + shiftX, shiftY, shiftX);
	}
	return i;
    }


    private boolean fixOverlap(String word, int intersectY, int intersectX){
        for (int i = 0; i < word.length(); i++){
	    if (word.charAt(i) == data[intersectY][intersectX]){
		for (int x = -1; x <= 1; x ++){
		    for (int y = -1; y <= 1; y++){
			if (checkSpace(intersectY, intersectX, -y, -x) > i &&
			    checkSpace(intersectY, intersectX, y, x) >= word.length() - i){
			    addWord(word.substring(0,i), intersectY - y * i, intersectX - x * i, y, x);
			    addWord(word.substring(i,word.length()), intersectY, intersectX, y, x);
			    return true;
			}
		    }
		}
	    }
	}
	return false;
    }
}
