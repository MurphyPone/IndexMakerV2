import java.util.TreeMap;

public class DocumentIndex extends TreeMap<String, IndexEntry> { //Represents the entire index for the document, list of all its index entries	
	
	public DocumentIndex() {
		super();
	}
	
	//Only thing to be modified?
	public void addWord(String word, int lnNum) { 
		//if(this.containsKey(word) )
		if(this.containsKey(word)) {	//If the IE at the keyStr exists, add the number 
			this.get(word).add(lnNum);	//TODO toUPPER keys
		} else { //IE doesn't exist for the given word
			this.put(word, new IndexEntry(word, lnNum));
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
}

