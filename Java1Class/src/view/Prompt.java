package view;

public enum Prompt {
	//All Menus
	INVALID_INPUT("Invalid input."),
	SELECT_OPTION("Please select one of the options above."),
	//Registration Menus
	REGISTRATION_SUCCESS("Registration Successful."),
	REGISTRATION_FAIL("Registration unsuccessful.  You may already be enrolled in this course."),
	//Create Account Menus
	ABORT("Are you sure you want to return to the main menu?"),
	ENTER_FIRST_NAME("Enter your first name."),
	ENTER_LAST_NAME("Enter your last name."),
	ENTER_USERNAME("Enter a username."),
	DUPLICATE_USERNAME("Please choose another username."),
	ENTER_EMAIL("Enter your email address."),
	ENTER_PHONE_NUMBER("Enter your phone number."),
	INVALID_PHONE_NUMBER("Please enter phone number without any spaces or formatting."),
	NEW_ACCOUNT("You have successfully created a new account.");
	
	private String prompt;
	
	Prompt(String decoration){
		this.prompt = decoration;
	}
	@Override
	public String toString(){
		return prompt;
	}

}
