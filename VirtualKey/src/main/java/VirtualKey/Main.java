package VirtualKey;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {	
	public static void main(String[] args) {
		FileService fileServ = new FileService();
		fileServ.start();
	}
}
