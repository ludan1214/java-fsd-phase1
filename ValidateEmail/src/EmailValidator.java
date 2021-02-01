import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	public boolean search(String query, String[] emailArr) {
		for (String email : emailArr) {
			if(email.equals(query)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// Dummy Email Array
		String[] emails = {"dummy@mail.com", "dummy2@mail.com", "luc.le@hcl.com"};
		
		if (args.length != 1) {
			System.out.println("No arguments provided");
		} else {
			String mailQuery = args[0];	
			System.out.println("Email entered: " + mailQuery);
			
			
			// Setup validation for the email query
			EmailValidator validator = new EmailValidator();
			String emailRegex = "^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(emailRegex);
			Matcher matcher = pattern.matcher(mailQuery);
			
			System.out.println("Is a valid email: "+ matcher.matches());
			System.out.println("Email Array to search: " + Arrays.toString(emails));
			
			System.out.println("Found: " + validator.search(mailQuery, emails));
		}
	}
}
