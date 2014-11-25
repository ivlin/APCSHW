import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	Random rand = new Random();
	WordGrid a = new WordGrid(10,10);
	File infile = new File("./wordlist.txt");
	Scanner sc = new Scanner(infile);
	sc.useDelimiter("\n");
	ArrayList<String> wordList = new ArrayList<>();
	while (sc.hasNext()){
	    wordList.add(sc.next());
	}
	for (int i = 0; i < wordList.size(); i++){
	    a.addWord(wordList.get(i), rand.nextInt(10), rand.nextInt(10), rand.nextInt(3) - 1, rand.nextInt(3) - 1);
	}
	System.out.println(a);

    }
}
