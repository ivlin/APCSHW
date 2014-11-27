import java.util.*;
import java.io.*;
public class WordGrid{
    private char[][]data;

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

    public boolean addWord(String word, int startY, int startX, int shiftY, int shiftX){
	boolean added;
	if (!(shiftY == 0 && shiftX == 0) && maxFit(word, startY, startX, shiftY, shiftX) >= word.length()){
		for (int i = 0; i < word.length(); i++){
		    data[startY + i * shiftY][startX + i * shiftX] = word.charAt(i);
		}
		return true;
	}
	return false;
    }

    public int maxFit(String word, int startY, int startX, int dy, int dx){
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
