import java.util.Arrays;

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
			EmailValidator validator = new EmailValidator();
			String mailQuery = args[0];	
			System.out.println("Email Array: " + Arrays.toString(emails));
			System.out.println("Email entered: " + mailQuery);
			System.out.println("Found: " + validator.search(mailQuery, emails));
		}
	}
}
