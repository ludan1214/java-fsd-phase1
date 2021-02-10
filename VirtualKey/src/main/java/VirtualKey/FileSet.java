package VirtualKey;

import java.io.File;
import java.util.TreeSet;

public class FileSet {
	private static TreeSet<String> treeSet = new TreeSet<String>();
	
	public FileSet() {
		try {
			File f = new File(System.getProperty("user.dir"));
			File[] files = f.listFiles();
			if (files.length != 0) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()) 
						this.treeSet.add(files[i].getName());
		        }
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public boolean add(String filename) {
		return treeSet.add(filename);
	}
	
	public boolean delete(String filename) {
		return treeSet.remove(filename);
	}
	
	public boolean search(String filename) {
		return treeSet.contains(filename);
	}
	
	@Override
	public String toString() {
		StringBuilder setStr = new StringBuilder();
		for (String filename : this.treeSet) {
			setStr.append(filename + "\n");
		}
		return setStr.toString();
	}
}
