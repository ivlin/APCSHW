import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[]args){
	try{
	    WordGrid a = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));

	    if (args.length > 2){
		a.setSeed(Integer.parseInt(args[2]));
		try{
		    a.loadWordsFromFile("wordlist.txt", !args[3].equals("1"));
		}catch (FileNotFoundException x){    
		}  
	    }else{
		try{
		    a.loadWordsFromFile("wordlist.txt", true);
		}catch (FileNotFoundException x){    
		}  
	    }
	    
	    System.out.println( "Find these words:\n"+ a.wordsInPuzzle() );
	    System.out.println( a );
	}catch (ArrayIndexOutOfBoundsException e){
	    System.out.println("You must run: \njava Driver row col [randomSeed cheatCode?(yes = 1)");
	}
    }
}
