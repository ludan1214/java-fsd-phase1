package calculator;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class ArithCalc {
	private static double solve(String lhs, String rhs, String op) {
		double left = Double.parseDouble(lhs);
		double right = Double.parseDouble(rhs);
		double result = 0;
		if (op.equals("+")) {
			result = left + right;
		} else if (op.equals("-")) {
			result = left - right;
		} else if (op.equals("*")){
			result = left * right;
		} else if (op.equals("/")){
			result = left / right;
		} else {
			System.out.println("Invalid Operation");
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		
		boolean keep_going = true;
		while (keep_going) {
			System.out.println("Enter First Value");
			String left = reader.readLine();
			System.out.println("Enter Operation type (+ - * /):");
			String op = reader.readLine();
			System.out.println("Enter Second Value");
			String right = reader.readLine();

			double result = solve(left, right, op);
			System.out.println("Result: " + result);
			
			System.out.println("\n");
			System.out.println("Keep going? (y/n)");
			String cont = reader.readLine();
			if (!cont.equals("y")) {
				keep_going = false;
			}
		}
		
	}
}
