package model;

public class ContactInfo {
	
	private final String email;
	private final long phoneNumber;
	
	public ContactInfo(String email, long phoneNumber){
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail(){
		return email;
	}
	public long getPhoneNumber(){
		return phoneNumber;
	}
	@Override
	public String toString(){
		return email + "| " + phoneNumber;
	}
}
