package VirtualKey;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {	
	public static void main(String[] args) {
		FileService fileServ = new FileService();
		FileSet set = new FileSet();
		System.out.println(
		"|~~~~~~~~~~~~~~~~~~~~~~~~~|\n" +
		"|         Welcome!        |\n" +
		"| - Phase 1 End Project   |\n" +
		"| - Written by Luc Le     |\n" +
		"|~~~~~~~~~~~~~~~~~~~~~~~~~|\n");
		fileServ.start(set);
	}
}
