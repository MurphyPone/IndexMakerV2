import java.util.TreeSet;

public class IndexEntry implements Comparable<IndexEntry> {
	private String word;	//the individual word
	private TreeSet<Integer> numsList; //Contains line numbers where <word> occurs 
	
	//Default constructor
	public IndexEntry(String a) {
		word = a.toUpperCase();
		numsList = new TreeSet<Integer>();
	}
	
	//Adds 
	public void add(int num) {	//Appends num to numslist if it is not already in the list
		if(!numsList.contains(num)) {	//numsList does not already have that num 
			numsList.add(num);
		}
	}
	
	//Helper for addWords...
	public TreeSet<Integer> getNumsList() {
		return numsList;
	}
	
	public String getWord() {
		return word;
	}
	
	public String toString() {	
		String result = word + " ";	
				for (Integer i : numsList) {
			if(i == numsList.last() )
				result += i ; //Adds the line where the number appears "foo	4, 5"
			else 
				result += i + ", ";
		}
		return result;
	}

	@Override
	public int compareTo(IndexEntry arg0) {
		return getWord().compareTo(arg0.getWord());
	}
}
