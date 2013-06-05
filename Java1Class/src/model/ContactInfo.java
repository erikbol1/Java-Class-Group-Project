package model;

public class ContactInfo {
	
	private String email;
	private long phoneNumber;
	
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
