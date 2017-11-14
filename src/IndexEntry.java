import java.util.TreeSet;

public class IndexEntry implements Comparable<IndexEntry> {
	private String word;	//the individual word to match to a key 
	private TreeSet<Integer> numSet; //Contains line numbers where <word> occurs 
	
	//Default constructor
	public IndexEntry(String theWord) {
		word = theWord.toUpperCase();
		numSet = new TreeSet<Integer>();
	}
	
	//Better constructor
	public IndexEntry(String theWord, int lnNum) {
		word = theWord.toUpperCase();
		numSet = new TreeSet<Integer>();
		numSet.add(lnNum);
	}
	
	//Adds 
	public void add(int num) {	//Appends num to numslist if it is not already in the list
		if(!numSet.contains(num)) {	//numsList does not already have that num 
			numSet.add(num);
		}
	}
	
	//Helper for addWords...
	public TreeSet<Integer> getNumSet() {
		return numSet;
	}
	
	public String getWord() {
		return word;
	}
	
	public String toString() {	
		String result = word + " ";	
		for (Integer i : numSet) {	//For each int in the numset which contains lnNums
			if(i == numSet.last() )	//If it's the last one, don't add a comma
				result += i.toString(); //Adds the line where the number appears "foo	4, 5"
			else 
				result += i.toString() + ", ";
		}
		return result;
	}

	@Override
	public int compareTo(IndexEntry arg0) {
		return getWord().compareTo(arg0.getWord());
	}
}
