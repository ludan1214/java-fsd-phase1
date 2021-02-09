package VirtualKey;

import java.io.File;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;

public class FileService {
	public void displayDirectory(String directory) {
		try {
			File f = new File(directory);
			File[] files = f.listFiles();
			
			if (files.length == 0) {
				System.out.println("Empty Directory!");
			} else {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()) 
						System.out.println(files[i].getName());
		        }
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void addFile(String filename){
		try {
			File f = new File(filename);
			if (f.createNewFile()) {
				System.out.println("File Successfully Added: " + filename);
			} else {
				System.out.println("File Already Exists");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void deleteFile(String filename) {
		try {
			File f = new File(filename);
			if (f.exists()) {
				f.delete();
				System.out.println(filename + " successfully deleted!");
			} else {
				System.out.println("File not found");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private boolean search(String filename) {
		File f = new File(System.getProperty("user.dir"));
		File[] files = f.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().equals(filename)) {
				return true;
			}
		}
		return false;
	}
	
	public void performOps() {
		int option = 0;
		Scanner sc = new Scanner(System.in);
		boolean opt2 = true;
		while (opt2) {
			System.out.println("Select an option:\n" + "1. Add a file to the directory\n"
					+ "2. Delete a file from the directory\n" 
					+ "3. Search for a file in the directory\n"
					+ "4. Return");
			try { 
				option = sc.nextInt();
			}
			catch (Exception e){
				System.out.println(e.toString());
				performOps();
				return;
			}
			switch (option) {
			case 1: // Add a File
				System.out.println("Enter a filename to add:");
				String in = sc.next();
				addFile(in);
				break;
			case 2: // Delete a file
				System.out.println("Enter a filename to delete:");
				in = sc.next();
				deleteFile(in);
				break;
			case 3: // Search a user
				System.out.println("Enter a filename to search:");
				in = sc.next();
				if (search(in)) {
					System.out.println(in + " found!");
				} else {
					System.out.println(in + " not found!");
				}
				break;
			case 4: // Navigate back to main context
				System.out.println("Returning to main context...");
				opt2 = false;
				break;
			default:
				System.out.println("You have made an invalid choice!");
				break;
			}
		}
	}
	
	public void start() {
		FileSet set = new FileSet();
		boolean keepGoing = true;
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		while (keepGoing) {
			System.out.println("Welcome!");
			System.out.println("Select an option:\n" + 
					"1. Display the current directory\n" +
					"2. Perform Operations\n" + 
					"3. Exit the application");
			try { 
				option = sc.nextInt();
			}
			catch (Exception e){
				System.out.println(e.toString());
				start();
				return;
			}
			switch (option) {
			case 1: // Print out filenames in relative directory
				System.out.println("Current File Names");
				displayDirectory(System.getProperty("user.dir"));
				break;
			case 2: // Return details of user interface
				performOps();
				break;
			case 3: // Exit
				System.out.println("Application Exited!");
				keepGoing = false;
				break;
			default:
				System.out.println("You have made an invalid choice!");
				break;
			}
		}
	}
	
}
