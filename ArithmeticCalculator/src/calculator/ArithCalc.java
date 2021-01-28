package calculator;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class ArithCalc {
	private static double solve(String lhs, String rhs, String op) {
		float left = 0, right = 0;
		double result = 0;
		try {
			left = Float.parseFloat(lhs);
			right = Float.parseFloat(rhs);
		}
		catch (Exception e) {
			System.out.println("Invalid input!");
			System.out.println(e.toString());
			result = -1;
		}
		if (op.equals("+")) {
			result = (double) left + right;
		} else if (op.equals("-")) {
			result = (double) left - right;
		} else if (op.equals("*")){
			result = (double) left * right;
		} else if (op.equals("/")){
			result = (double) left / right;
		} else {
			System.out.println("Invalid Operation");
			result = -1;
		}
		System.out.println("Result: " + result);
		return result;
	}
	
	private static String[] parse(String str) {
		String[] res = new String[3];
		String[] temp = new String[2];
		if ((temp = str.split("\\+")).length == 2) {
			res[0] = temp[0];
			res[1] = "+";
			res[2] = temp[1];
		} else if ((temp = str.split("\\-")).length == 2) {
			res[0] = temp[0];
			res[1] = "-";
			res[2] = temp[1];
		} else if ((temp = str.split("\\*")).length == 2) {
			res[0] = temp[0];
			res[1] = "*";
			res[2] = temp[1];
		} else if ((temp = str.split("\\/")).length == 2) {
			res[0] = temp[0];
			res[1] = "/";
			res[2] = temp[1];
		} else {
			res = str.split(" ");
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		boolean keep_going = true;
		
		while (keep_going) {
			System.out.println("Enter a simple arithmetic expression:");
			String line = reader.readLine();
			String[] parsed = parse(line);
			if(parsed.length != 3) {
				System.out.println("Invalid Input! Can only handle 2 terms");
				continue;
			}
			solve(parsed[0], parsed[2], parsed[1]);
			
			System.out.println("Keep going? (y/n)");
			String cont = reader.readLine();
			if (!cont.equals("y")) {
				keep_going = false;
				System.out.println("Thanks for using the calculator!");
			}
		}
		
	}
}
