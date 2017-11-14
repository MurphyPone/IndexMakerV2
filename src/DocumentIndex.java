import java.util.TreeMap;

public class DocumentIndex extends TreeMap<String, IndexEntry> { //Represents the entire index for the document, list of all its index entries	
	
	public DocumentIndex() {
		super();
	}
	
	//Only thing to be modified?
	public void addWord(String word, int lnNum) { 
		if(!word.equals("") ) {
			String key = word.toUpperCase();
				//this. is unnecessary, but helps me understand what's going on
			if(this.containsKey(key)) {	//If the IE at the keyStr exists, add the number 
				this.get(key).add(lnNum);	
			} else { //IE doesn't exist for the given word
				this.put(key, new IndexEntry(key, lnNum));
			}
		}
	}
	
	//Accepts a line, and ln number, separates them, and adds each individual line in 
	public void addAllWords(String str, int lnNum) { 
		String[] words = str.split("\\W+"); //should split str into individual word elements w/o punctuation
		
		if(words.length > 0) {	//Has elements, and is therefore valid
			for(String word : words) {
				if(!word.equals("")); 	//Skip empty strings, redundant check on regex working properly
					addWord(word, lnNum);
			}
		} else {System.out.println("Invalid String");}	//makes it here, but doesn't print...
	}
}

