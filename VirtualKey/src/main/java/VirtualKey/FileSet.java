package VirtualKey;

import java.util.TreeSet;

public class FileSet {
	private static TreeSet<String> treeSet = new TreeSet<String>();
	
	public boolean add(String filename) {
		return treeSet.add(filename);
	}
	
	public boolean delete(String filename) {
		return treeSet.remove(filename);
	}
	
	public boolean search(String filename) {
		return treeSet.contains(filename);
	}
}
