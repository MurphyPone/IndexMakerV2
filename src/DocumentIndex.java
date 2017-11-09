import java.util.TreeMap;

public class DocumentIndex extends TreeMap<Integer> { //Represents the entire index for the document, list of all its index entries	
	
	public DocumentIndex() {
		super();
	}
	
	public DocumentIndex(int size) {
		super(size);
	}
	
	public void addWord(String word, int lnNum) { 
		int index = foundOrInserted(word);	//Gets the alphabetical index of the given word in the overall "book" Index
	
		if(index > -1) {		//The word exists within the Index 
			IndexEntry entry = this.get(index);	//temp var for the matching entry 
			entry.getNumsList().add(lnNum);	//Adds the lnNum to the entry's list of nums
		} else { //If index ! >-1 then the given word isn't a real word and shouldn't be added
			System.out.println(word); //empty strings
		}
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
	
	
	//Not sure what this is for
	private int foundOrInserted(String word) {	//Returns the index of the place it belongs
		if(!word.equals("")) {		//Is a valid string
			int i = 0;
			if(this.size() > 0) { //DocumentIndex is not empty 
				String lWord = this.get(i).getWord();
				while(i < this.size() && word.compareToIgnoreCase(lWord) > 0) {	//gets next Word
					i++;
					if(i < this.size())	//check bounds
						lWord = this.get(i).getWord();	//reset value to next word
				}
				
				if(!word.equalsIgnoreCase(lWord)) {	//Entry does not match at this spot 
					this.add(i, new IndexEntry(word));	//create a new one 
				}
				return i; //return the index of the word 
			
			} else {	//DocIndex is empty 
				this.add(i, new IndexEntry(word));	//create a new one 
				return i;
			}
		}
		return -1;	//invalid 
	}

}
