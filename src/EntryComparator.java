import java.util.Comparator;

public class EntryComparator implements Comparator<IndexEntry>{

	@Override
	public int compare(IndexEntry arg0, IndexEntry arg1) {
		return arg0.getWord().compareTo(arg1.getWord());
	}
	
	public boolean equals(Object arg0, Object arg1) {
		if(arg0 instanceof IndexEntry && arg1 instanceof IndexEntry)
			return (((IndexEntry) arg0).compareTo((IndexEntry)arg1) == 0);	//Alternatively cast to index entry.getWord.equals(arg1.getWord())
		else return false;
	}
}
