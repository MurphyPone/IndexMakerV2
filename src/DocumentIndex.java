import java.util.TreeMap;

public class DocumentIndex extends TreeMap<String, Integer> { //Represents the entire index for the document, list of all its index entries	
	
	public DocumentIndex() {
		super();
	}
	
	public void addWord(String word, int lnNum) { 
		//TODO PICKUP HERE
		
		/*
		int index = foundOrInserted(word);	//Gets the alphabetical index of the given word in the overall "book" Index
	
		if(index > -1) {		//The word exists within the Index 
			IndexEntry entry = this.get(index);	//temp var for the matching entry 
			entry.getNumSet().add(lnNum);	//Adds the lnNum to the entry's list of nums
		} else { //If index ! >-1 then the given word isn't a real word and shouldn't be added
			System.out.println(word); //empty strings
		}
		*/
	}
	
	public void addAllWords(String str, int lnNum) { 
		String[] words = str.split("\\W+"); //should split str into individual word elements w/o punctuation
		
		if(words.length > 0) {	//HAs elements, and is therefore valid
			for(String word : words) {
				if(!word.equals("") ); 	//Not empty
					addWord(word, lnNum);
			}
		} else {System.out.println("Invalid String");}	//makes it here, but doesn't print...
	}
}

