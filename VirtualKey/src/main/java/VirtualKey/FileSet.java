package VirtualKey;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileSet {
	private static ArrayList<String> set = new ArrayList<String>();
	
	public FileSet() {
		try {
			File f = new File(System.getProperty("user.dir"));
			File[] files = f.listFiles();
			if (files.length != 0) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()) 
						this.set.add(files[i].getName());
		        }
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public boolean add(String filename) {
		return this.set.add(filename);
	}
	
	public boolean delete(String filename) {
		return this.set.remove(filename);
	}
	
	public int search(String filename) {
		// Ensure case insensitivity
		ArrayList<String> temp = (ArrayList<String>) this.set.clone();
		for (String str : temp) {
			str.toLowerCase();
		}
		return Collections.binarySearch(temp, filename.toLowerCase());
	}
	
	public void sort() {
		Collections.sort(this.set); // Merge sort in Collections
	}
	
	@Override
	public String toString() {
		StringBuilder setStr = new StringBuilder();
		for (String filename : this.set) {
			setStr.append(filename + "\n");
		}
		return setStr.toString();
	}
}
