package com.WebServices.BOSWeb;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class TestValidations {

	public static void main(String[] args) {
		String panNum="jubpk9130d";
	//	boolean validate = validate(panNum.toUpperCase());
		String adharNum="";
		String email="krishme45498@gkjcas.scom";
//		AnsiConsole.systemInstall();
//
//	    System.out.println(Ansi.ansi()
//	        .fgRed()
//	        .a("Some red text")
//	        .fgBlue()
//	        .a(" and some blue text")
//	        .reset());
//
//	    AnsiConsole.systemUninstall();
		
		generateRandome(8);
	}

	private static void generateRandome(int len) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("AccountNumber", "123455664");
		map.put("CustomerID", "0000000");
		System.err.println(map.get("CustomerID"));
		int min=1,max=9;
		String ran = "";
		Random random=new Random();
		for(int i=0;i<len;i++) {
			int randomNum=random.nextInt(max - min + 1)+min;
			ran=ran+randomNum;
		}
		System.out.println(ran);
		
	}

	private static boolean validateEmail(String email) {
		// Regular expression for a basic email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Return true if the email matches the pattern, else false
        return email.matches(emailRegex);
	}

	private static boolean validateAdhar(String aadharCardNumber ) {
		// Regular expression for a valid Aadhaar card number
        String aadharCardRegex = "^[2-9]{1}[0-9]{11}$";

        // Return true if the Aadhaar card number matches the pattern, else false
        return aadharCardNumber.matches(aadharCardRegex);
		
	}

	private static boolean validate(String panNum) {
		// Regular expression for a valid PAN card number
        String panCardRegex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(panCardRegex);

        // Match the given PAN card number with the pattern
        Matcher matcher = pattern.matcher(panNum);

        // Return true if the PAN card number matches the pattern, else false
        return matcher.matches();
		
	}

}
