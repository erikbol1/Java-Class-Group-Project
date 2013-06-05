package main;

import persistance.DataRepository;
import persistance.StudentRepository;

public enum AuthenticationService {
	INSTANCE;
	
	private StudentRepository studentRepository;
	AuthenticationService(){
		studentRepository = DataRepository.INSTANCE;
	}
	
	public boolean validate(String username){
		if (username == null)
			return false;
		return (studentRepository.getStudent(username) != null) ? true: false;
	}

}
