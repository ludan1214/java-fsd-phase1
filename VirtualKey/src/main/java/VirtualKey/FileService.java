package VirtualKey;

import java.io.File;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;

public class FileService {
	private boolean addFile(String filename){
		try {
			File f = new File(filename);
			if (f.createNewFile()) {
				System.out.println("File Successfully Added: " + filename);
				return true;
			} else {
				System.out.println("File Already Exists");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		return false;
	}
	
	private boolean deleteFile(String filename) {
		try {
			File f = new File(filename);
			if (f.exists()) {
				f.delete();
				System.out.println(filename + " successfully deleted!");
				return true;
			} else {
				System.out.println("File not found");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
	
	public void performOps(FileSet set) {
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
				performOps(set);
				return;
			}
			switch (option) {
			case 1: // Add a File
				System.out.println("Enter a filename to add:");
				String in = sc.next();
				if (addFile(in)) {
					set.add(in);
				}
				System.out.println("Current files in List:");
				System.out.println(set.toString());
				break;
			case 2: // Delete a file
				System.out.println("Enter a filename to delete:");
				in = sc.next();
				if (deleteFile(in)) {
					set.delete(in);
				}
				System.out.println("Current files in List:");
				System.out.println(set.toString());
				break;
			case 3: // Search a user
				System.out.println("Enter a filename to search:");
				in = sc.next();
				if (set.search(in)) {
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
	
	public void start(FileSet set) {
		boolean keepGoing = true;
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		while (keepGoing) {
			System.out.println("Select an option:\n" + 
					"1. Display the current directory\n" +
					"2. Perform Operations\n" + 
					"3. Exit the application");
			try { 
				option = sc.nextInt();
			}
			catch (Exception e){
				System.out.println(e.toString());
				start(set);
				return;
			}
			switch (option) {
			case 1: // Print out filenames in relative directory
				System.out.println("Current File Names");
				System.out.println(set.toString());
				break;
			case 2: // Return details of user interface
				performOps(set);
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
