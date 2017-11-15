/**
 * Class Description: This class represents a collection of sorted IndexEntries, storing the in a TreeMap based on their keywords
 * @author MurphyP1
 * @date 11/15/17
 */

import java.util.TreeMap;

public class DocumentIndex extends TreeMap<String, IndexEntry> {	//Extends the TreeMap class, inheriting all of a TreeMap's methods, and allowing me to define more, specific to Treemaps 	
	
	/**
	 * The default constructor for a DocumentIndex which calls the default constructor for a vanilla Treemap
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method DocumentIndex
	 */
	public DocumentIndex() {
		super();	//Same thing as this = new TreeMap<String, IndexEntry>();
	}
	
	/**
	 * A method which either adds a line number to an existing IndexEntry's numSet, or creates a new IndexEntry for a given word and lineNumber
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method addWord
	 * 
	 * @param word a String which is used to find the existing IndexEntry or create a new one
	 * @param lnNum an int which is added to an IndexEntry's numSet
	 */
	public void addWord(String word, int lnNum) { 
		if(!word.equals("") ) {	//If the word is not blank or an \n
			String key = word.toUpperCase();	//Converts the word to uppercase for standard storage in the TreeMap
				//"this." is unnecessary, but helps me understand what's going on
			if(this.containsKey(key)) {	//If the IE at the key exists
				this.get(key).add(lnNum);	//Add the lnNum to the indexEntry for that keyword
			} else { //IndexEntry doesn't exist for the given word
				this.put(key, new IndexEntry(key, lnNum));  //Create a new onewith the given word and lnNum
			}
		}
	}
	
	/**
	 * A method which accepts a line, and line number, separates each word in the line, and adds it to the DocumentIndex 
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method addWord
	 * 
	 * @param str a String which represents a full line in a document
	 * @param lnNum an int which is added to a respective IndexEntry's numSet
	 */
	public void addAllWords(String str, int lnNum) { 
		String[] words = str.split("\\W+"); //should split str into individual word elements w/o punctuation or spaces
		
		if(words.length > 0) {	//Has elements, and is therefore valid
			for(String word : words) {
				if(!word.equals("")); 	//Skip empty strings, redundant check on regex working properly
					addWord(word, lnNum);
			}
		} else {System.out.println("Invalid String");}	//makes it here, but doesn't print...
	}
}

