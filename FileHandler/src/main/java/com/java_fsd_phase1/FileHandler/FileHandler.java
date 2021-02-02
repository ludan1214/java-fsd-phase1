package com.java_fsd_phase1.FileHandler;

import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler {
	public static void printContents(String filename) throws IOException{
		// Read File
		File file = new File(filename);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String s = in.readLine();
		System.out.println(filename + " contents:");
		while (s!= null ) {
			System.out.println(s);
			s = in.readLine();
		} 
		in.close();
	}
	
	public static void appendContents(String filename, String content) throws IOException {
		Files.write(Paths.get(filename), content.getBytes(), StandardOpenOption.APPEND);
	}
	
	public static void writeContents(String filename, String content) throws IOException {
		Files.write(Paths.get(filename), content.getBytes(), StandardOpenOption.WRITE);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the name of the file you would like to read:");
		String filename = in.nextLine();
		File file = new File(filename);
		if (file.isFile() != true) {
			System.out.println(filename + " not found! Exiting program");
		} else {
			printContents(filename);
			System.out.println("Type a string to write to the file:");
			String contents = in.nextLine();
			System.out.println("Would you like to append to or overwrite the file?");
			System.out.println("type append or write");
			String choice = in.nextLine();
			while (!choice.equals("append") && !choice.equals("write")) {
				System.out.println(choice + " is not an option!");
			}
			if (choice.equals("append")) {
				appendContents(filename, contents);
			} else { // write
				writeContents(filename, contents);
			}
			
			System.out.println("File" + filename + "Modified! Contents: ");
			printContents(filename);
		}
	}
}
