/**
 * Class Description: This class represents a single entry in an index, storing the key word and line number of occurrences
 * @author MurphyP1
 * @date 11/15/17
 */

import java.util.TreeSet;

public class IndexEntry {
	private String word;	//The individual word to match to a key 
	private TreeSet<Integer> numSet; //Contains line numbers where the word occurs 
	
	/**
	 * The default constructor for an IndexEntry which only accepts the keyword
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method IndexEntry
	 * 
	 * @param theWord a String which is used to define the entry's keyword
	 */
	public IndexEntry(String theWord) {
		word = theWord.toUpperCase();
		numSet = new TreeSet<Integer>();
	}
	
	/**
	 * An expanded constructor for an IndexEntry which accepts both the keyword and an initial line number
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method IndexEntry
	 * 
	 * @param theWord a String which is used to define the entry's keyword
	 * @param lnNum an integer which is immediately added to the TreeSet storing occurences of the keyword an a document
	 */
	public IndexEntry(String theWord, int lnNum) {
		word = theWord.toUpperCase();
		numSet = new TreeSet<Integer>();
		numSet.add(lnNum);
	}
	
	/**
	 * A method which adds a line number where the keyword occurs to that entry's TreeSet as long as it is not already listed in the Set
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method add
	 * 
	 * @param num the line number where the word occurred in a document which is added to the entry's TreeSet
	 */ 
	public void add(int num) {	//Appends num to numSet if it is not already in the Set
		if(!numSet.contains(num)) {	//numSet does not already have that num 
			numSet.add(num);
		}
	}
	
	/**
	 * A getter method which returns the IndexEntry's numSet
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method getNumSet
	 * 
	 * @return the IndexEntry's TreeSet of line numbers 
	 */ 
	public TreeSet<Integer> getNumSet() {
		return numSet;
	}
	
	/**
	 * A getter method which returns the IndexEntry's word
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method getWord
	 * 
	 * @return the IndexEntry's key word
	 */ 
	public String getWord() {
		return word;
	}
	
	/**
	 * A toString method which formats the result of an IndexEntry with respect to its appearance in a series of other indexEntries 
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method toString
	 * 
	 * @return a String displaying the word followed by all the lin numbers separated by commas
	 */ 
	public String toString() {	
		String result = word + " ";	
		for (Integer i : numSet) {	//For each int in the numSet which contains lnNums
			if(i == numSet.last() )	//If it's the last one, don't add a comma
				result += i.toString(); //Only adds the line where the number appears "foo	4, 5"
			else 
				result += i.toString() + ", ";	//Adds the line where the number appears AND a comma
		}
		return result;
	}
}
