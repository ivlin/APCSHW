import java.util.*;
import java.io.*;
public class WordGrid{
    private char[][]data;
    private ArrayList<String> words = new ArrayList<>();
    private Random rand = new Random();

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows, int cols){
	data = new char[rows][cols];
	clear();
    }

    /**Initialize the grid to the default size of 10 by 10
     */
    public WordGrid(){
	this(10,10);
    }

    public void setSeed(int seed){
	rand.setSeed(seed);
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

    /**Takes a list of words in the given file and adds it to a wordgrid
     *@param fileName is the name of the file containing the words
     *@param fillRandomLetters is a boolean deciding whether or not to fill up the empty spaces of the word grid
     */
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters) throws FileNotFoundException{
	File infile = new File(fileName);
	Scanner sc = new Scanner(infile);
	ArrayList<String> wordList = new ArrayList<>();
	while (sc.hasNext()){
	    wordList.add(sc.nextLine());
	}
	randomAddList(wordList);
	if (fillRandomLetters){
	    fillRandomLetters();
	}
    }

    /**Given an ArrayList of words, attempts to add each words to the word grid.
     */
    public void randomAddList(ArrayList<String> wordList){
	for (int i = 0; i < wordList.size(); i++){
	    boolean added = false;
	    for (int tries = 10; tries > 0 && !added; tries--){
		added = addWord(wordList.get(i), rand.nextInt(data.length), rand.nextInt(data[0].length), rand.nextInt(3) - 1, rand.nextInt(3) - 1);
		if (added){
		    words.add(wordList.get(i));
		}
	    }
	}
    }

    /**@return String of words used in word grid
     */
    public String wordsInPuzzle(){
	String str = "";
	for (int i = 0; i < words.size(); i++){
	    str += words.get(i);
	    for (int n = words.get(i).length(); n < 20; n++){
		str += " ";
	    }
	    if (i % 3 == 2){
		str += "\n";
	    }
	}
	return str;
    }

    /**Attempts to add String word to the WordGrid
     *@param word is String of the word to be added
     *@param startY is the integer of the row the word should start at
     *@param startX is the integer of the column the world should start at
     *@param shiftY is the number of spaces right each letter in the word is from the last
     *@param shiftX is the number of spaces down each letter in the word is from the last
     *@return whether or not the word was succesfully added to the word grid 
     */
    public boolean addWord(String word, int startY, int startX, int shiftY, int shiftX){
	int maxFit = maxFit(word, startY, startX, shiftY, shiftX);
	if (!(shiftY == 0 && shiftX == 0)){ 
	    if (maxFit >= word.length()){
		for (int i = 0; i < word.length(); i++){
		    data[startY + i * shiftY][startX + i * shiftX] = word.charAt(i);
		}
		return true;
	    }else{
		return fixOverlap(word, startY, startX);
	    }
	}
	return false;
    }

    /**Fills empty spaces in the word grid with random characters
     */
    public void fillRandomLetters(){
	for (int y = 0; y < data.length; y++){
	    for (int x = 0; x < data[y].length; x++){
		if (data[y][x] == '.'){
		data[y][x] = (char)(rand.nextInt(25) + 'a');
		}
	    }
	}
    }

    private int maxFit(String word, int startY, int startX, int dy, int dx){
	if (word.length() > 0 && startY >= 0 && startY < data.length && startX >= 0 && startX < data[0].length &&
	   (data[startY][startX] == '.' || data[startY][startX] == word.charAt(0))){
	    return 1 + maxFit(word.substring(1, word.length()), startY + dy, startX + dx, dy, dx);
	}
	return 0;
    }
    
    private boolean fixOverlap(String word, int intersectY, int intersectX){
        for (int i = 0; i < word.length(); i++){
	    if (word.charAt(i) == data[intersectY][intersectX]){
		for (int x = -1; x <= 1; x ++){
		    for (int y = -1; y <= 1; y++){
			if (maxFit(word, intersectY, intersectX, -y, -x) > i &&
			    maxFit(word, intersectY, intersectX, y, x) >= word.length() - i){
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
