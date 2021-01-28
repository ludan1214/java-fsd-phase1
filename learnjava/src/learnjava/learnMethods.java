package learnjava;

import java.util.ArrayList;

public class learnMethods {
	public static int returnAnInt(float a) { return (int) a;}
	public static int returnAnInt(double a) { return (int) a;}
	
	public static void main(String args[]) {
		double myDouble = 5.0;
		float myFloat = 4.0f;
		
		ArrayList<Person> people = new ArrayList<Person>();
		
		System.out.println(returnAnInt(myDouble));
		
	}
}
